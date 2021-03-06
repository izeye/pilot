package com.ctb.pilot.stat.model;

public class DailyVisitLog {

	private String day;
	private Long count;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DailyVisitLog [day=" + day + ", count=" + count + "]";
	}

}
