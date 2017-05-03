package com.neleth.kata.fibonacci;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FibonacciTest {

	private void asssertValue(int ordinal, long expected) {
		assertEquals(BigInteger.valueOf(expected), new Fibonacci(ordinal).value());
	}


	private void checkSequence(int ordinal, String expected) {
		Fibonacci testObj = new Fibonacci(ordinal);
		assertTrue(expected.equals(testObj.getSequence()));
	}

	@Test
	public void values() {
		asssertValue(0, 0);
		asssertValue(1, 1);
		asssertValue(2, 1);
		asssertValue(3, 2);
		asssertValue(4, 3);
		asssertValue(5, 5);
		asssertValue(6, 8);
		asssertValue(50, 12586269025l);
	}

	@Test
	public void sequences() {
		checkSequence(1, "1");
		checkSequence(2, "1 1");
		checkSequence(5, "1 1 2 3 5");
		checkSequence(10, "1 1 2 3 5 8 13 21 34 55");
	}

}
