package com.ctb.pilot.common.util;

import java.util.List;

import org.junit.Test;

import com.ctb.pilot.common.model.Country;

public class CountryUtilsTest {

	@Test
	public void getCountries() {
		List<Country> countries = CountryUtils.getCountries();
		System.out.println(countries);
	}

	@Test
	public void getCountryByCode() {
		// String countryCode = "KR";
		String countryCode = "CS";
		Country country = CountryUtils.getCountryByCode(countryCode);
		System.out.println(country);
	}

}
