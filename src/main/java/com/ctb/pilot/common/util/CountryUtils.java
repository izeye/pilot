package com.ctb.pilot.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

import com.ctb.pilot.common.model.Country;

public class CountryUtils {

	private static final List<Country> countries = new ArrayList<Country>();
	private static final Map<String, Country> codeAndNameMap = new HashMap<String, Country>();
	static {
		Locale[] availableLocales = Locale.getAvailableLocales();
		for (Locale locale : availableLocales) {
			try {
				String iso = locale.getISO3Country();
				String code = locale.getCountry();
				String name = locale.getDisplayCountry(Locale.US);
				if (iso.isEmpty() || code.isEmpty() || name.isEmpty()
						|| codeAndNameMap.get(code) != null) {
					continue;
				}
				Country country = new Country(iso, code, name);
				countries.add(country);
				codeAndNameMap.put(code, country);
			} catch (MissingResourceException e) {
				System.err.println(e);
			}
		}
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static List<Country> getCountries() {
		return countries;
	}

	public static Country getCountryByCode(String code) {
		return codeAndNameMap.get(code);
	}

}
