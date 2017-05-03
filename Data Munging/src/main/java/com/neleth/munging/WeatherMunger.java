package com.neleth.munging;

public class WeatherMunger extends Munger{
	private Integer lowestSpreadLineNmber;
	
	public WeatherMunger(String filename) {
		this.filename = filename;
		munge();
	}

	protected void readLine(String line) {
		if (isNotSummaryLine(line)) {
			Integer[] values = new WeatherLineParser(line).retrieveValues();
			if (null != values)
				updateLowestSpread(values, calculateSpread(values));
		}
	}

	void updateLowestSpread(Integer[] values, int spread) {
		if (lowestSpread > spread ) {
			lowestSpread = spread;
			lowestSpreadLineNmber = values[0];
		}
	}

	boolean isNotSummaryLine(String line) {
		return !line.startsWith("  mo");
	}

	Integer calculateSpread(Integer[] values) {
		return values[1] - values[2];
	}

	public Integer getLowestSpreadLineNumber() {
		return lowestSpreadLineNmber;
	}

}
