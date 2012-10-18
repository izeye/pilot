package com.ctb.pilot.chat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtils {
	
	public static String decorateEmoticon(String text) {
		String pattern = "(icon-[a-z-]*)";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(text);
		return matcher.replaceAll("<i class=\"$0\"></i>");
	}

}
