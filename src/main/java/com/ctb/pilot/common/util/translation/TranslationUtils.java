package com.ctb.pilot.common.util.translation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.ctb.pilot.chat.model.Message;
import com.ctb.pilot.common.util.JsonUtils;

public class TranslationUtils {
	public static String getDetect(String accessToken, String text)
			throws ClientProtocolException, IOException {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(
				"http://api.microsofttranslator.com/V2/Ajax.svc/Detect?appId=Bearer"
						+ new URLEncoder().encode(" " + accessToken) + "&text="
						+ new URLEncoder().encode(text));
		HttpResponse httpResponse = httpClient.execute(httpGet);
		return EntityUtils.toString(httpResponse.getEntity()).substring(2, 4);
	}

	public static String getAccessToken() throws ClientProtocolException,
			IOException {
		DefaultHttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost(
				"https://datamarket.accesscontrol.windows.net/v2/OAuth2-13");

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("client_id", "jpmlyr"));
		parameters.add(new BasicNameValuePair("client_secret",
				"h5UfkHjJy/KWKk4KCF0FkJBI4RGnkWx/b1VvEM1rJDc="));
		parameters.add(new BasicNameValuePair("scope",
				"http://api.microsofttranslator.com"));
		parameters.add(new BasicNameValuePair("grant_type",
				"client_credentials"));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse httpResponse = client.execute(post);

		String accessToken = JsonUtils.getProperty("access_token",
				EntityUtils.toString(httpResponse.getEntity()));

		return accessToken;
	}

	public static String getJsonToAccessToken() throws ParseException,
			IOException {
		DefaultHttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost(
				"https://datamarket.accesscontrol.windows.net/v2/OAuth2-13");

		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("client_id", "jpmlyr"));
		parameters.add(new BasicNameValuePair("client_secret",
				"h5UfkHjJy/KWKk4KCF0FkJBI4RGnkWx/b1VvEM1rJDc="));
		parameters.add(new BasicNameValuePair("scope",
				"http://api.microsofttranslator.com"));
		parameters.add(new BasicNameValuePair("grant_type",
				"client_credentials"));
		post.setEntity(new UrlEncodedFormEntity(parameters));
		HttpResponse httpResponse = client.execute(post);
		String temp = EntityUtils.toString(httpResponse.getEntity());

		return temp;
	}

	public static boolean getCheckLanguage(String text, String localeStr)
			throws ClientProtocolException, IOException {
		String detectedText = TranslationUtils.getDetect(
				TranslationUtils.getAccessToken(), text);

		return !detectedText.equals(localeStr);
	}

	public static String getLanguage(String text)
			throws ClientProtocolException, IOException {
		String detectedText = TranslationUtils.getDetect(
				TranslationUtils.getAccessToken(), text);
		return detectedText;
	}

	public static List makeCheckedList(List list)
			throws ClientProtocolException, IOException {
		Message message;
		for (int i = 0; i < list.size(); i++) {
			message = (Message) list.get(i);
			message.setCheckedText(TranslationUtils.getCheckLanguage(
					message.getMessage(), "ko"));
			list.set(i, message);
		}

		return list;
	}
}
