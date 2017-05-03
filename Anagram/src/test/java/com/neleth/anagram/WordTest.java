package com.neleth.anagram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordTest {

	void assertAnagram(String text1, String text2) {
		assertTrue(new Word(text1).isAnagramOf(new Word(text2)));
	}

	void assertNotAnagram(String text1, String text2) {
		assertFalse(new Word(text1).isAnagramOf(new Word(text2)));
	}


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void creates_word() {
		String text = "";
		new Word(text);
	}
	
	@Test 
	public void matching_words_are_anagrams()
	{
		assertAnagram("A", "A");
		assertAnagram("Foo", "Foo");
		assertAnagram("", "");
	}
	
	@Test
	public void not_anagrams() {
		assertNotAnagram("A","B");
		assertNotAnagram("Hello", "Goodbye");
		assertNotAnagram(null, null);
	}

	@Test 
	public void two_letter_anagrams()
	{
		assertAnagram("AB", "BA");
		assertAnagram("foo", "oof");
		assertAnagram("Foo", "oof");
	}

	@Test
	public void getLength_returns_text_length() {
		assertEquals(0, new Word(null).getLength());
		assertEquals(3, new Word("Foo").getLength());
	}

}
