package com.ctb.pilot.stat.model;

public class DailyVisitIpLog {

	private String ip;
	private Long count;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DailyVisitIpLog [ip=" + ip + ", count=" + count + "]";
	}

}
