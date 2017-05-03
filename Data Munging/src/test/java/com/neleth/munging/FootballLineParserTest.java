package com.neleth.munging;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballLineParserTest implements CanCompareArrays{
	String[] lines;
	FootballLineParser lineParser;
	
	@Before
	public void setUp() throws Exception {
		lines = new String[3];
		lines[0] = "   Team            P     W    L   D    F      A     Pts";
		lines[1] = "1. Arsenal         38    26   9   3    79  -  36    87";	

		lineParser = new FootballLineParser(lines[1]);
	}

	@Test
	public void returns_values() {
		assertNotNull(lineParser.retrieveValues());
		assertArrayEquals(new Integer[]{79, 36}, lineParser.retrieveValues());
	}
	
	@Test
	public void returns_Team() {
		assertEquals("Arsenal", lineParser.findTeamNameInLine());
	}

}
