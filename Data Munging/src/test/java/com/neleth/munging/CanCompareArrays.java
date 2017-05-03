package com.neleth.munging;

import static org.junit.Assert.assertEquals;

public interface CanCompareArrays {

	default void assertValuesMatch(Integer[] expected, Integer[] actual1) {
		for (int i =0; i < expected.length; i++)
			assertEquals(expected[i], actual1[i]);
	}

}