package com.neleth.munging;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballMungerTest {
	
	String filename = "d:/Downloads/football.dat";
	private FootballMunger munger;
	
	@Before
	public void setup()
	{
		munger = new FootballMunger(filename);
	}

	@Test
	public void gets_values_from_file() {
		munger.munge();
		
		assertEquals(20, munger.getLineCount());
	}
	
	@Test 
	public void minimal_spread() {
		munger.munge();
		
		assertEquals(Integer.valueOf(1), munger.getLowestSpread());
		assertEquals("Aston_Villa", munger.getTeamWithMinimumSpread());
	}

}
