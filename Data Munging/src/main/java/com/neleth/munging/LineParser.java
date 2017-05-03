package com.neleth.munging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LineParser {
	public static Pattern DIGIT_PATTERN = Pattern.compile("\\d+");
	protected String line;

	public Integer[] retrieveValues() {
		Matcher m = getLinePattern().matcher(line.trim());
		return m.find() ? extractValuesFromLineSegment(m.group(0)) : null;
	}

	protected Matcher createDigitMatcher(String text) {
		Matcher m = DIGIT_PATTERN.matcher(text);
		return m;
	}

	protected abstract Integer[] extractValuesFromLineSegment(String region);

	protected abstract int getFieldCount(); 

	protected abstract Pattern getLinePattern();


}