package com.ctb.pilot.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.stereotype.Controller;

@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = "com.ctb.pilot", excludeFilters = {
		@Filter(Configuration.class), @Filter(Controller.class) })
@PropertySource("classpath:com/ctb/pilot/config/application.properties")
//@PropertySource("classpath:com/ctb/pilot/config/application.local.properties")
public class MainConfig {

	@Bean(destroyMethod = "shutdown")
	public DataSource h2DataSource() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseName("pilot");
		factory.setDatabaseType(EmbeddedDatabaseType.H2);
		factory.setDatabasePopulator(databasePopulator());
		return factory.getDatabase();
	}

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource(
				"JdbcUsersConnectionRepository.sql",
				JdbcUsersConnectionRepository.class));
		return populator;
	}

}
