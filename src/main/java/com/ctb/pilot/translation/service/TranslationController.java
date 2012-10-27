package com.ctb.pilot.translation.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.common.util.translation.TranslationUtils;

@Controller
public class TranslationController {

	@RequestMapping("/services/translation/accessToken.do")
	public void getAccessToken(HttpServletRequest request,
			HttpServletResponse response) throws ClientProtocolException,
			IOException {
		String temp = TranslationUtils.getJsonToAccessToken();
		System.out.println(temp);
		PrintWriter out = response.getWriter();
		out.print(temp);
		out.flush();
		out.close();
	}
}
