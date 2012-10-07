package com.ctb.pilot.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public static InputStream urlToInputStream(String urlAsString)
			throws IOException {
		URL url = new URL(urlAsString);
		return url.openStream();
	}

}
