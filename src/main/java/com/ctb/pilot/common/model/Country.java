package com.ctb.pilot.common.model;

public class Country {

	private final String iso;
	private final String code;
	private final String name;

	public Country(String iso, String code, String name) {
		this.iso = iso;
		this.code = code;
		this.name = name;
	}

	public String getIso() {
		return iso;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Country [iso=" + iso + ", code=" + code + ", name=" + name
				+ "]";
	}

}
