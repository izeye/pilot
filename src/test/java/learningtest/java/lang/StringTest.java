package learningtest.java.lang;

import java.util.Arrays;

import org.junit.Test;

public class StringTest {

	@Test
	public void split() {
		String string = "a b\tc d\t e";
		String[] splitString = string.split("[\t ]+");
		System.out.println(Arrays.asList(splitString));
	}

}
