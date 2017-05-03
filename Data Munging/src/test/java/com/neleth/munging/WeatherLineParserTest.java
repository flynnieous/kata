package com.neleth.munging;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherLineParserTest implements CanCompareArrays {
	String line1 = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
	String line2 = "   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5";
	String line3 = "   9  86    32*   59       6  61.5       0.00         240  7.6 220  12  6.0  78 46 1018.6";
	String line4 = "  26  97*   64    81          70.4       0.00 H       050  5.1 200  12  4.0 107 45 1014.9";
	Integer[] lineValues1 = new Integer[]{1, 88, 59};
	Integer[] lineValues2 = new Integer[]{2, 79, 63};
	Integer[] lineValues3 = new Integer[]{9, 86, 32};
	Integer[] lineValues4 = new Integer[]{26, 97, 64};
	
	@Test
	public void can_find_three_values() {
		assertValuesMatch(lineValues1, new WeatherLineParser(line1).retrieveValues());
		assertValuesMatch(lineValues2, new WeatherLineParser(line2).retrieveValues());
		assertValuesMatch(lineValues3, new WeatherLineParser(line3).retrieveValues());
		assertValuesMatch(lineValues4, new WeatherLineParser(line4).retrieveValues());
	}
	
	@Test
	public void not_found_returns_null() {
		String line = "dfa gads  324   g  5235  gasdaggag";
		
		assertNull(new WeatherLineParser(line).retrieveValues());
	}

}
