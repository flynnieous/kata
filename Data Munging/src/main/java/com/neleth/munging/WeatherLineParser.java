package com.neleth.munging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherLineParser extends LineParser {

	public static Pattern WEATHER_PATTERN = Pattern.compile("\\d+\\s+\\d+\\**\\s+\\d+");
	public static int WEATHER_FIELD_COUNT = 3;

	Pattern linePattern;
	int fieldCount;

	public WeatherLineParser(String line) {
		this.line = line;
	}

	@Override
	protected int getFieldCount() {
		return WEATHER_FIELD_COUNT;
	}

	@Override
	protected Pattern getLinePattern() {
		return WEATHER_PATTERN;
	}

	@Override
	protected Integer[] extractValuesFromLineSegment(String lineSegment) {
		String[] valuesRenderedAsText = lineSegment.split("\\s+");
		return populateValuesFromText(valuesRenderedAsText);
	}

	private Integer[] populateValuesFromText(String[] valueStrings) {
		Integer[] values = new Integer[WEATHER_FIELD_COUNT];
		for (int i = 0; i < valueStrings.length; i++) 
			values[i] = convertTextToNumbers(valueStrings[i]);
		return values;
	}

	protected Integer convertTextToNumbers(String text) {
		Matcher m = createDigitMatcher(text);
		return m.find() ? Integer.valueOf(m.group(0)) : null;
	}
}
