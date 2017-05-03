package com.neleth.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word implements Comparable<Word>{
	private final String text;
	private final String sortedText;

	public Word(String text) {
		this.text = null != text ? text.trim() : null;
//				eSpecialCharacters(text.trim());
		this.sortedText = sortText();
	}

	public boolean isAnagramOf(Word word2) {
		return null != word2 && null != sortedText && null != word2.sortedText
				&& sortedText.equalsIgnoreCase(word2.sortedText);
	}

	String eSpecialCharacters(String text) {
		List<Character> letterList = toLetterList(text);
		return new String(toCharacterArray(letterList));
	}

	private char[] toCharacterArray(List<Character> letterList) {
		char[] letters = new char[letterList.size()];
		for (int i = 0; i < letterList.size(); i++)
			letters[i] = letterList.get(i);
		return letters;
	}

	private List<Character> toLetterList(String text) {
		char[] characters = text.toCharArray();
		List<Character> letterList = new ArrayList<Character>();
		for (char character : characters)
//			if (Character.isAlphabetic(character))
				letterList.add(character);
		return letterList;
	}

	String sortText() {
		String sortedWord = null;
		if (null != text) {
			List<Character> letterList = toLetterList(text);
			Collections.sort(letterList);
			char[] letters = toCharacterArray(letterList);
			sortedWord = new String(letters);
		}
		return sortedWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public int compareTo(Word o) {
		int c = -1;
		if (null != text) 
			c = (null == o || null == o.text) ?  1 : text.compareTo(o.text);
		return c;
	}

	public String getText() {
		return text;
	}

	public String getSortedText() {
		return sortedText;
	}
	
	public int getLength() {
		return null != text ? text.length() : 0;
	}
}
