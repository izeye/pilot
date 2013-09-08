package com.ctb.pilot.common.model;

public class Country {

	private String iso;
	private String code;
	private String name;

	public Country(String iso, String code, String name) {
		this.iso = iso;
		this.code = code;
		this.name = name;
	}

	public Country() {
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [iso=" + iso + ", code=" + code + ", name=" + name
				+ "]";
	}

}
