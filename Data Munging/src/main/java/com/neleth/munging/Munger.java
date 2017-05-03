package com.neleth.munging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class Munger {

	protected String filename;
	protected Integer lowestSpread = Integer.MAX_VALUE;
	protected int lineCount;

	public void munge() {
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			stream.forEach(line -> readLine(line));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	protected abstract void readLine(String line);

	public Integer getLowestSpread() {
		return lowestSpread;
	}

	public int getLineCount() {
		return lineCount;
	}

}