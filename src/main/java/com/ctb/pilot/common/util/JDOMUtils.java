package com.ctb.pilot.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDOMUtils {

	public static Element inputStreamToRoot(InputStream is)
			throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(is);
		return doc.getRootElement();
	}

}
