package com.ctb.pilot.chat.util;

import org.junit.Test;

public class ChatUtilsTest {

	@Test
	public void decorateEmoticon() {
		String text = "icon-search";
		String decoratedText = ChatUtils.decorateEmoticon(text);
		System.out.println(decoratedText);
		
		text = "icon-thumbs-up";
		decoratedText = ChatUtils.decorateEmoticon(text);
		System.out.println(decoratedText);
		
		text = "icon-search icon-thumbs-up";
		decoratedText = ChatUtils.decorateEmoticon(text);
		System.out.println(decoratedText);
	}

}
