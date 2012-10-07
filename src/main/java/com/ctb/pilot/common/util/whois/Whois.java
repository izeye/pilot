package com.ctb.pilot.common.util.whois;

public class Whois {

	private String ipAddress;
	private String countryCode;
	private String koreanIspOrgName;
	private String koreanIspAddr;
	private String koreanUserOrgName;
	private String koreanUserAddr;
	private String englishIspOrgName;
	private String englishIspAddr;
	private String englishUserOrgName;
	private String englishUserAddr;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getKoreanIspOrgName() {
		return koreanIspOrgName;
	}

	public void setKoreanIspOrgName(String koreanIspOrgName) {
		this.koreanIspOrgName = koreanIspOrgName;
	}

	public String getKoreanIspAddr() {
		return koreanIspAddr;
	}

	public void setKoreanIspAddr(String koreanIspAddr) {
		this.koreanIspAddr = koreanIspAddr;
	}

	public String getKoreanUserOrgName() {
		return koreanUserOrgName;
	}

	public void setKoreanUserOrgName(String koreanUserOrgName) {
		this.koreanUserOrgName = koreanUserOrgName;
	}

	public String getKoreanUserAddr() {
		return koreanUserAddr;
	}

	public void setKoreanUserAddr(String koreanUserAddr) {
		this.koreanUserAddr = koreanUserAddr;
	}

	public String getEnglishIspOrgName() {
		return englishIspOrgName;
	}

	public void setEnglishIspOrgName(String englishIspOrgName) {
		this.englishIspOrgName = englishIspOrgName;
	}

	public String getEnglishIspAddr() {
		return englishIspAddr;
	}

	public void setEnglishIspAddr(String englishIspAddr) {
		this.englishIspAddr = englishIspAddr;
	}

	public String getEnglishUserOrgName() {
		return englishUserOrgName;
	}

	public void setEnglishUserOrgName(String englishUserOrgName) {
		this.englishUserOrgName = englishUserOrgName;
	}

	public String getEnglishUserAddr() {
		return englishUserAddr;
	}

	public void setEnglishUserAddr(String englishUserAddr) {
		this.englishUserAddr = englishUserAddr;
	}

	@Override
	public String toString() {
		return "Whois [ipAddress=" + ipAddress + ", countryCode=" + countryCode
				+ ", koreanIspOrgName=" + koreanIspOrgName + ", koreanIspAddr="
				+ koreanIspAddr + ", koreanUserOrgName=" + koreanUserOrgName
				+ ", koreanUserAddr=" + koreanUserAddr + ", englishIspOrgName="
				+ englishIspOrgName + ", englishIspAddr=" + englishIspAddr
				+ ", englishUserOrgName=" + englishUserOrgName
				+ ", englishUserAddr=" + englishUserAddr + "]";
	}

}
