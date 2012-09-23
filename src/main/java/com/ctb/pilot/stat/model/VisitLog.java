package com.ctb.pilot.stat.model;

import java.util.Date;

public class VisitLog {
	private int sequence;
	private Date visitDate;
	private String ip;
	private String uri;
	private String referer;
	private String userAgent;

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String toString() {
		return "VisitLog [sequence=" + sequence + ", visitDate=" + visitDate
				+ ", ip=" + ip + ", uri=" + uri + ", referer=" + referer
				+ ", userAgent=" + userAgent + "]";
	}

}
