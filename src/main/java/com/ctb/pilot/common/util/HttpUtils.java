package com.ctb.pilot.common.util;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			System.out.println(name);
			if (name.equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

}
