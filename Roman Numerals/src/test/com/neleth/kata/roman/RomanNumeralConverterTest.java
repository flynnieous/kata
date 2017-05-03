package com.neleth.kata.roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralConverterTest {

	private void assertRomanNumeral(Integer arabic, String expected) {
		assertEquals(expected, new Numeral(arabic).getRomanNumeral());
	}

	@Test
	public void testOne() {
		assertRomanNumeral(1, "I");
	}

	@Test
	public void testTwo() {
		assertRomanNumeral(2, "II");
	}

	@Test
	public void testThree() {
		assertRomanNumeral(3,"III");
	}

	@Test
	public void testFour() {
		assertRomanNumeral(4, "IV");
	}

	@Test
	public void testFive() {
		assertRomanNumeral(5, "V");
	}

	@Test
	public void testSix() {
		assertRomanNumeral(6, "VI");
	}

	@Test
	public void testNine() {
		assertRomanNumeral(9, "IX");
	}

	@Test
	public void testTen() {
		assertRomanNumeral(10, "X");
	}

	@Test
	public void testFourteen() {
		assertRomanNumeral(14, "XIV");
	}

	@Test
	public void testFifteen() {
		assertRomanNumeral(15, "XV");
	}

	@Test
	public void testSixteen() {
		assertRomanNumeral(16, "XVI");
	}

	@Test
	public void testNineteen() {
		assertRomanNumeral(19, "XIX");
	}

	@Test
	public void testTwenty() {
		assertRomanNumeral(20, "XX");
	}

	@Test
	public void testTwentyNine() {
		assertRomanNumeral(29, "XXIX");
	}

	@Test
	public void testThirty() {
		assertRomanNumeral(30, "XXX");
	}

	@Test
	public void testThirtyNine() {
		assertRomanNumeral(39, "XXXIX");
	}

	@Test
	public void testForty() {
		assertRomanNumeral(40, "XL");
	}

	@Test
	public void testFifty() {
		assertRomanNumeral(50, "L");
	}

	@Test
	public void testNinetyNine() {
		assertRomanNumeral(99, "XCIX");
	}

	@Test
	public void testOneHundred() {
		assertRomanNumeral(100, "C");
	}

	@Test
	public void testFourHundred() {
		assertRomanNumeral(400, "CD");
	}

	@Test
	public void testFiveHundred() {
		assertRomanNumeral(500, "D");
	}

	@Test
	public void testNineHundred() {
		assertRomanNumeral(900, "CM");
	}

	@Test
	public void testOneThousand() {
		assertRomanNumeral(1000, "M");
	}

	@Test
	public void testNineteenNinetyNine() {
		assertRomanNumeral(1999, "MCMXCIX");
	}

	@Test
	public void testFourteenSixtyNine() {
		assertRomanNumeral(1469, "MCDLXIX");
	}

	@Test
	public void test2017() {
		assertRomanNumeral(2017, "MMXVII");
	}

	@Test(expected = com.neleth.kata.roman.Numeral.InvalidRomanNumeral.class)
	public void testZero() {
		new Numeral(0).getRomanNumeral();
	}

	@Test(expected = com.neleth.kata.roman.Numeral.InvalidRomanNumeral.class)
	public void testNegative() {
		new Numeral(-99).getRomanNumeral();
	}

}
