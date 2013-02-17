package com.ctb.pilot.config;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.ctb.pilot.user.facebook.PilotSignInAdapter;
import com.ctb.pilot.user.facebook.SecurityContext;
import com.ctb.pilot.user.facebook.User;

@Configuration
public class SocialConfig {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	private Environment environment;

	@Resource(name = "h2DataSource")
	private DataSource dataSource;

	@Resource
	private ConnectionSignUp connectionSignUp;

	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(environment
				.getProperty("facebook.clientId"), environment
				.getProperty("facebook.clientSecret")));
		return registry;
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
				dataSource, connectionFactoryLocator(), Encryptors.noOpText());
		repository.setConnectionSignUp(connectionSignUp);
		return repository;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
		User user = SecurityContext.getCurrentUser();
		return usersConnectionRepository().createConnectionRepository(
				user.getId());
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Facebook facebook() {
		log.debug("dataSource: " + dataSource);
		return connectionRepository().getPrimaryConnection(Facebook.class)
				.getApi();
	}

	@Bean
	public ProviderSignInController providerSignInController() {
		return new ProviderSignInController(connectionFactoryLocator(),
				usersConnectionRepository(), new PilotSignInAdapter());
	}

}
