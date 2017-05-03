package com.neleth.kata.roman;

public enum RomanNumeralConsolidator {
	FOUR("IIII", "IV"),
	NINE("VIV", "IX"),
	FORTY("XXXX", "XL"),
	NINETY("LXL", "XC"),
	FOUR_HUNDRED("CCCC", "CD"),
	NINE_HUNDRED("DCD", "CM");
	
	final String longSegment;
	final String shortSegment;
	
	private RomanNumeralConsolidator(String longSegment, String shortSegment) {
		this.longSegment = longSegment;
		this.shortSegment = shortSegment;
	}

	private int locateLongSegment(String numeral) {
		return numeral.indexOf(longSegment);
	}
	
	private class NumeralReplacer {
		private StringBuilder builder;
		
		private NumeralReplacer(String numeral) {
			builder = new StringBuilder(numeral);
		}
		
		private String replaceInLine(Integer locationIndex){
			if (locationIndex >= 0) {
				builder.delete(locationIndex, builder.length());
				builder.append(shortSegment);
			}
			return builder.toString();
		}
	}

	public String consolidate(String numeral) {
		NumeralReplacer builder = new NumeralReplacer(numeral);
		return builder.replaceInLine(locateLongSegment(numeral));
	}

}
