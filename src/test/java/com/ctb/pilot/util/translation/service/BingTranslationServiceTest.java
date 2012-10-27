package com.ctb.pilot.util.translation.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BingTranslationServiceTest {

	@Autowired
	private BingTranslationService translationService;

	@Test
	public void detectLanguage() {
		String language = translationService.detectLanguage("안녕하세요.");
		assertThat(language, is("ko"));

		language = translationService.detectLanguage("Hello.");
		assertThat(language, is("en"));
	}

	@Test
	public void getAccessTokenAsJson() throws UnsupportedEncodingException,
			ClientProtocolException, IOException {
		String accessTokenAsJson = translationService.getAccessTokenAsJson();
		System.out.println(accessTokenAsJson);
	}

}
