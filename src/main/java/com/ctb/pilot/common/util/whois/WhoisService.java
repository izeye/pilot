package com.ctb.pilot.common.util.whois;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("whoisService")
public class WhoisService {

	private final Map<String, Whois> ipAndWhoisMap = new HashMap<String, Whois>();

	public Whois getWhois(String ipAddress) {
		Whois whois = ipAndWhoisMap.get(ipAddress);
		if (whois == null) {
			whois = WhoisUtils.ipToWhois(ipAddress);
			ipAndWhoisMap.put(ipAddress, whois);
		}
		return whois;
	}

}
