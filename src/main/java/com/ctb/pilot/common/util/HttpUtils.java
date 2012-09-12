package com.ctb.pilot.common.util;

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

}
