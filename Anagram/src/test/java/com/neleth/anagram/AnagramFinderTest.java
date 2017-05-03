package com.neleth.anagram;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramFinderTest {

	static AnagramFinder finder;
	
	@BeforeClass
	public static void setUp() throws Exception {
		finder = new AnagramFinder("d:/Downloads/wordlist.txt");
	}


	@Test
	public void can_list_anagrams() {
		int mostAnagrams = 0;
		for (List<Word> anagramList : finder.getWords().values())
			mostAnagrams = (anagramList.size() > mostAnagrams) ? anagramList.size() : mostAnagrams;
		assertEquals(338882, finder.getWords().values().size());
		assertEquals(Integer.valueOf(20683), finder.getAnagramCount());
		assertEquals(12, mostAnagrams);
	}

	@Test
	public void determine_longest_anagrams() {
		assertEquals(Integer.valueOf(19), finder.getLongestAnagramLength());
		assertTrue(finder.getLongestAnagrams().contains("acoustoelectrically"));
		assertTrue(finder.getLongestAnagrams().contains("electroacoustically"));
	}

	@Test
	public void determine_most_anagrams() {
		assertEquals(Integer.valueOf(13), finder.getHighestAnagramCount());
	}
	

	@AfterClass
	public static void tearDown() {
		finder = null;
	}
}
