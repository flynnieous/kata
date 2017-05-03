package com.neleth.kata.fibonacci;

import java.math.BigInteger;

public class Fibonacci {

	int ordinal;
	BigInteger[] sequence;
	
	public Fibonacci(int ordinal) {
		this.ordinal = ordinal;
		sequence = new BigInteger[ordinal];
		createSequence();
	}

	private void createSequence() {
		for (int i =0; i < ordinal; i++) 
			fillInSequenceItem(i);
	}

	private void fillInSequenceItem(int index) {
		if (index < 2) 
			sequence[index] = BigInteger.ONE;
		else 
			sequence[index] = sequence[index-1].add(sequence[index-2]);
	}

	public BigInteger value() {
		if (ordinal < 1) {
			return BigInteger.ZERO;
		}
		return sequence[ordinal-1];
	}

	public String getSequence() {
		String str = "";
		for (int i = 0; i < ordinal; i++)
			str += addSpaceIfNotFirstItem(i) + sequence[i];
		return str;
	}

	private String addSpaceIfNotFirstItem(int index) {
		return index > 0 ?" " : "";
	}

}
