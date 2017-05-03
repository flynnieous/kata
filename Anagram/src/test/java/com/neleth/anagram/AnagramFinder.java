package com.neleth.anagram;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class AnagramFinder {
	SortedMap<Word, List<Word>> wordToAnagramMap;
	SortedMap<String, SortedSet<Word>> sortedTextMap;
	List<SortedSet<Word>> largestSetsOfAnagrams;
	SortedMap<Integer, SortedSet<String>> textSizeMap;
	int highestAnagramCount;

	public AnagramFinder(String filename) {
		init();

		try (Stream<String> stream = Files.lines(Paths.get(filename), StandardCharsets.ISO_8859_1)) {
			stream.forEach(line -> readWord(line));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		populateTextSizeAndLargestSetMaps();
	}

	private void populateTextSizeAndLargestSetMaps() {
		for (Map.Entry<String, SortedSet<Word>> entry : sortedTextMap.entrySet()) {
			int size = entry.getValue().size();
			if (size > highestAnagramCount) 
				highestAnagramCount = resetHighestAnagramCount(size);
			if (size == highestAnagramCount)
				largestSetsOfAnagrams.add(entry.getValue());
		}
	}

	private int resetHighestAnagramCount(int size) {
		largestSetsOfAnagrams = new ArrayList<SortedSet<Word>>();
		return size;
	}

	private void init() {
		wordToAnagramMap = new TreeMap<Word, List<Word>>();
		sortedTextMap = new TreeMap<String, SortedSet<Word>>();
		textSizeMap = new TreeMap<Integer, SortedSet<String>>();
		highestAnagramCount = 0;
	}

	void readWord(String line) {
		Word word = new Word(line.trim());
		determineAnagrams(word);
	}

	void determineAnagrams(Word word) {
		if (isInAnagramList(word))
			addWordThatIsAnagram(word);
		else
			addWordThatHasNoAnagarmsYet(word);
	}

	private void addWordThatIsAnagram(Word word) {
		wordToAnagramMap.put(word, getAnagramsFromSortedTextMap(word));
		sortedTextMap.get(word.getSortedText()).add(word);
		updateTextSizeMap(word);
	}

	private ArrayList<Word> getAnagramsFromSortedTextMap(Word word) {
		return new ArrayList<Word>(sortedTextMap.get(word.getSortedText()));
	}

	private void updateTextSizeMap(Word word) {
		int length = word.getLength();
		if (textSizeMap.containsKey(length))
			textSizeMap.get(length).add(word.getText());
		else
			textSizeMap.put(length, convertToSortedSetOfStrings(sortedTextMap.get(word.getSortedText())));
	}

	void addWordThatHasNoAnagarmsYet(Word word) {
		wordToAnagramMap.put(word, new ArrayList<Word>());
		SortedSet<Word> anagrams = new TreeSet<Word>();
		anagrams.add(word);
		sortedTextMap.put(word.getSortedText(), anagrams);
	}

	boolean isInAnagramList(Word word) {
		return sortedTextMap.keySet().contains(word.getSortedText());
	}

	public Map<Word, List<Word>> getWords() {
		return wordToAnagramMap;
	}

	public Integer getAnagramCount() {
		int i = 0;
		for (Set<Word> anagrams : sortedTextMap.values())
			if (anagrams.size() > 1) 
				i++;
		return i;
	}

	public Integer getLongestAnagramLength() {
		return textSizeMap.lastKey();
	}

	public Object getHighestAnagramCount() {
		return largestSetsOfAnagrams.get(0).size();
	}

	public SortedSet<String> getLongestAnagrams() {
		return textSizeMap.get(getLongestAnagramLength());
	}

	public SortedSet<String> getLargestAnagramSet() {
		return convertToSortedSetOfStrings(largestSetsOfAnagrams.get(0));
	}

	private SortedSet<String> convertToSortedSetOfStrings(SortedSet<Word> words) {
		SortedSet<String> strings = new TreeSet<String>();
		for (Word word : words)
			strings.add(word.getText());
		return strings;
	}

	private void printLargestAnagramSets() {
		System.out.println("Largest set of anagrams: " + convertCollectionToString(getLargestAnagramSet()));
	}

	private void printLongestAnagrams() {
		System.out.println("Longest anagrams: " + convertCollectionToString(getLongestAnagrams()));
	}

	private void printAllAnagrams() {
		for (Set<Word> anagrams : sortedTextMap.values())
			printAnagramSet(anagrams);
	}

	private void printAnagramSet(Set<Word> anagrams) {
		if (anagrams.size() > 1) {
			Iterator<Word> word = anagrams.iterator();
			String output = word.next().getText();
			while (word.hasNext())
				output += ", " + word.next().getText();
			System.out.println(output);
		}
	}

	private String convertCollectionToString(Collection<String> collection) {
		String collectionString = "[";
		for (String str : collection)
			collectionString += " " + str + " ";
		collectionString += "]";
		return collectionString;
	}

	public static void main(String[] args) {
		AnagramFinder finder = new AnagramFinder(args[0]);
		finder.printAllAnagrams();
		finder.printLargestAnagramSets();
		finder.printLongestAnagrams();;
	}
}
