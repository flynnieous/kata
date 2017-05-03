package com.neleth.munging;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeatherMungerTest {

	static Integer[] FIRST_VALUES = new Integer[] {1, 88, 59};
	static Integer[] LAST_VALUES = new Integer[] {30, 90, 45};

	WeatherMunger munger;
	String filename = "d:/Downloads/weather.dat";

	@Before
	public void setUp() throws Exception {
		munger = new WeatherMunger(filename);
	}

	@Test
	public void spread_for_first_Values() {
		assertEquals(Integer.valueOf(29), munger.calculateSpread(FIRST_VALUES));
		
	}
	
	@Test
	public void lowest_spread() {
		assertEquals(Integer.valueOf(2), munger.getLowestSpread());
		assertEquals(Integer.valueOf(14), munger.getLowestSpreadLineNumber());
		
	}

}
