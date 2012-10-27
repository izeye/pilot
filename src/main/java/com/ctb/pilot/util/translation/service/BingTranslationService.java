package com.ctb.pilot.util.translation.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.ctb.pilot.common.util.JsonUtils;

@Service("translationService")
public class BingTranslationService implements TranslationService {

	private static final String BING_ACCESS_TOKEN_URL = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";

	private static final String KEY_CLIENT_ID = "client_id";
	private static final String VALUE_CLIENT_ID = "jpmlyr";

	private static final String KEY_GRANT_TYPE = "grant_type";
	private static final String VALUE_GRANT_TYPE = "client_credentials";

	private static final String KEY_SCOPE = "scope";
	private static final String VALUE_SCOPE = "http://api.microsofttranslator.com";

	private static final String KEY_CLIENT_SECRET = "client_secret";
	private static final String VALUE_CLIENT_SECRET = "h5UfkHjJy/KWKk4KCF0FkJBI4RGnkWx/b1VvEM1rJDc=";

	private static final String PLACEHOLDER_ACCESS_TOKEN = "${accessToken}";
	private static final String PLACEHOLDER_TEXT = "${text}";
	private static final String BING_LANGUAGE_DETECT_URL = "http://api.microsofttranslator.com/V2/Ajax.svc/Detect?appId=Bearer"
			+ PLACEHOLDER_ACCESS_TOKEN + "&text=" + PLACEHOLDER_TEXT;

	private String createLanguageDetectUrl(String accessToken, String text) {
		String encodedAccessToken = new URLEncoder().encode(" " + accessToken);
		String encodedText = new URLEncoder().encode(text);
		return BING_LANGUAGE_DETECT_URL.replace(PLACEHOLDER_ACCESS_TOKEN,
				encodedAccessToken).replace(PLACEHOLDER_TEXT, encodedText);
	}

	@Override
	public String detectLanguage(String text) {
		try {
			String accessToken = getAccessToken();
			DefaultHttpClient httpClient = new DefaultHttpClient();
			String languageDetectUrl = createLanguageDetectUrl(accessToken,
					text);
			HttpGet httpGet = new HttpGet(languageDetectUrl);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			return EntityUtils.toString(httpResponse.getEntity()).substring(2,
					4);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getAccessTokenAsJson() throws UnsupportedEncodingException,
			IOException, ClientProtocolException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BING_ACCESS_TOKEN_URL);

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair(KEY_CLIENT_ID, VALUE_CLIENT_ID));
		parameters
				.add(new BasicNameValuePair(KEY_GRANT_TYPE, VALUE_GRANT_TYPE));
		parameters.add(new BasicNameValuePair(KEY_SCOPE, VALUE_SCOPE));
		parameters.add(new BasicNameValuePair(KEY_CLIENT_SECRET,
				VALUE_CLIENT_SECRET));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse httpResponse = client.execute(post);
		return EntityUtils.toString(httpResponse.getEntity());
	}

	private String getAccessToken() throws ClientProtocolException, IOException {
		String accessTokenAsJson = getAccessTokenAsJson();
		return JsonUtils.getProperty("access_token", accessTokenAsJson);
	}

}
