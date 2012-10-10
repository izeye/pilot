package com.ctb.pilot.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtils {

	public static String decorateUrl(String text) {
		String pattern = "(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w\\.-]*)*\\/?";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(text);
		return matcher.replaceAll("<a href='$0' target='_blank'>$0</a>");
	}

}
