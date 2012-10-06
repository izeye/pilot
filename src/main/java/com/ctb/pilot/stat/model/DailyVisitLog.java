package com.ctb.pilot.stat.model;

public class DailyVisitLog {

	private String day;
	private String count;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DailyVisitLog [day=" + day + ", count=" + count + "]";
	}

}
