package com.neleth.kata.roman;

public class Numeral {

	final Integer arabic;

	public Numeral(Integer arabic) {
		this.arabic = arabic;
	}

	public Integer getArabicNumeral() {
		return (arabic);
	}

	public String getRomanNumeral() {
		checkIfValidRomanNumeral();
		NumeralSegment ns = NumeralSegment.make("", arabic);
		ns = convertDigits(ns);
		return ns.getNumeral();
	}

	private NumeralSegment convertDigits(NumeralSegment ns) {
		for (DigitConverter digitConverter : DigitConverter.values()) 
			ns = digitConverter.convert(ns);
		return ns;
	}
	
	private void checkIfValidRomanNumeral() {
		if (arabic < 1) 
			throw new InvalidRomanNumeral();
	}
	
	public static class InvalidRomanNumeral extends RuntimeException {
		private static final long serialVersionUID = -9211662269230322564L;
	}
}
