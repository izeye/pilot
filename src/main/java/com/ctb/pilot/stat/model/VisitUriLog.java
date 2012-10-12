package com.ctb.pilot.stat.model;

public class VisitUriLog {

	private String uri;
	private Long count;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DailyVisitUriLog [uri=" + uri + ", count=" + count + "]";
	}

}
