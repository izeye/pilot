package com.ctb.pilot.stat.model;

import com.ctb.pilot.common.util.whois.Whois;

public class DailyVisitIpLog {

	private String ip;
	private Whois whois;
	private Long count;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Whois getWhois() {
		return whois;
	}

	public void setWhois(Whois whois) {
		this.whois = whois;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DailyVisitIpLog [ip=" + ip + ", whois=" + whois + ", count="
				+ count + "]";
	}

}
