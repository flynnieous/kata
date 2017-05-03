package com.neleth.kata.roman;

public class NumeralSegment {

	final String numeral;
	final Integer remainder;
	
	
	private NumeralSegment(String numeral, Integer remainder) {
		this.numeral = numeral;
		this.remainder = remainder;
	}

	public static NumeralSegment make(String numeral, Integer remainder) {
		return new NumeralSegment(numeral, remainder);
	}
	
	public String getNumeral() {
		return numeral;
	}

	public Integer getRemainder() {
		return remainder;
	}
	
}
