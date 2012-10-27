package com.ctb.pilot.util.translation.service;

public interface TranslationService {

	String detectLanguage(String text);

	String translate(String text);

}
