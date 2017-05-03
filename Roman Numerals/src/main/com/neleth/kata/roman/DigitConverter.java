package com.neleth.kata.roman;

enum DigitConverter {
	THOUSAND(1000, "M", new RomanNumeralConsolidator[0]),
	FIVE_HUNDRED(500,"D", new RomanNumeralConsolidator[0]),
	HUNDRED(100, "C", new RomanNumeralConsolidator[] { RomanNumeralConsolidator.FOUR_HUNDRED, RomanNumeralConsolidator.NINE_HUNDRED}),
	FIFTY(50,"L", new RomanNumeralConsolidator[0]),
	TEN(10, "X", new RomanNumeralConsolidator[] { RomanNumeralConsolidator.FORTY, RomanNumeralConsolidator.NINETY}),
	FIVE(5,"V", new RomanNumeralConsolidator[0]),
	ONE(1, "I", new RomanNumeralConsolidator[] { RomanNumeralConsolidator.FOUR, RomanNumeralConsolidator.NINE});
	
	
	final Integer arabic;
	final String roman;
	final RomanNumeralConsolidator[] consolidators;
	
	private DigitConverter(Integer arabic, String roman, RomanNumeralConsolidator[] consolidators) {
		this.arabic = arabic;
		this.roman = roman;
		this.consolidators = consolidators;
	}

	public NumeralSegment convert(NumeralSegment segment){
		NumeralSegment newSegment = convertDigitsToLetters(segment);
		String numeral = consolodateLetters(newSegment.getNumeral());
		return NumeralSegment.make(numeral, newSegment.getRemainder());
	}
	
	private NumeralSegment convertDigitsToLetters(NumeralSegment segment) {
		StringBuilder builder = new StringBuilder(segment.getNumeral());
		for (int c = 0; c < segment.getRemainder() / arabic; c++)
			builder.append(roman);
		return NumeralSegment.make(builder.toString(), (segment.getRemainder() % arabic));
	}
	
	private String consolodateLetters(String newSegment) {
		for (RomanNumeralConsolidator consolidator : consolidators)
			newSegment = consolidator.consolidate(newSegment);
		return newSegment;
	}

}
