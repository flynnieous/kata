package com.neleth.munging;

import java.util.regex.Pattern;

public class FootballMunger extends Munger {
	
	public static Pattern TEAM_PATTERN = Pattern.compile("\\.\\s+.+");

	String teamWithMinimumSpread;
	
	public FootballMunger(String filename) {
		this.filename = filename;
	}

	protected void readLine(String line) {
		FootballLineParser parser = new FootballLineParser(line);
		Integer[] values = parser.retrieveValues();
		if (null != values){
			determineTeamWithMinimumSpread(parser, values);
			lineCount++;
		}
	}

	void determineTeamWithMinimumSpread(FootballLineParser parser, Integer[] values) {
		int spread = Math.abs(values[0] - values[1]);
		if (spread < lowestSpread) {
			lowestSpread = spread;
			teamWithMinimumSpread = parser.findTeamNameInLine();
		}
	}

	public Object getTeamWithMinimumSpread() {
		return teamWithMinimumSpread;
	}

}
