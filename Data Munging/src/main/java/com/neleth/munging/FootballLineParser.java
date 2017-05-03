package com.neleth.munging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballLineParser extends LineParser {
	public static Pattern FOOTBALL_PATTERN = Pattern.compile("\\d+\\s+\\-\\s+\\d+");
	public static Pattern TEAM_PATTERN = Pattern.compile("\\.\\s+.+\\d");

	public static int FOOTBALL_FIELD_COUNT = 2;

	public FootballLineParser(String line) {
		this.line = line;	
	}

	@Override
	protected Integer[] extractValuesFromLineSegment(String region) {
		Integer[] values = new Integer[getFieldCount()];
		Matcher m = createDigitMatcher(region);
		for (int i = 0; m.find(); i++)
			values[i] = Integer.valueOf(m.group(0));
		return values;
	}

	@Override
	protected int getFieldCount() {
		return FOOTBALL_FIELD_COUNT;
	}

	@Override
	protected Pattern getLinePattern() {
		return FOOTBALL_PATTERN;
	}

	public String findTeamNameInLine() {
		Matcher m = TEAM_PATTERN.matcher(line);
		return (m.find()) ? extractNameFromLine(m.group(0)) : null;
	}

	String extractNameFromLine(String segment) {
		String[] valueStrings = segment.split("\\s+");
		return valueStrings[1].trim();
	}

}
