package com.ctb.pilot.util.translation.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TranslationController {

	@Autowired
	private BingTranslationService translationService;

	@RequestMapping("/services/translation/accessToken.do")
	public void getAccessToken(HttpServletRequest request,
			HttpServletResponse response) throws ClientProtocolException,
			IOException {
		String temp = translationService.getAccessToken();
		System.out.println(temp);
		PrintWriter out = response.getWriter();
		out.print(temp);
		out.flush();
		out.close();
	}

}
