package com.ctb.pilot.util.ip.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.common.util.whois.Whois;
import com.ctb.pilot.common.util.whois.WhoisService;

@Controller
public class IpAddressInfoController {

	@Autowired
	private WhoisService whoisService;

	@RequestMapping("/services/ip/what_is_my_ip.do")
	public String whatIsMyIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		Whois whois = whoisService.getWhois(remoteAddr);
		request.setAttribute("whois", whois);

		return "/services/ip/what_is_my_ip_view";
	}

}
