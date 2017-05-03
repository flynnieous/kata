import static org.junit.Assert.*;

import org.junit.Test;

public class ChopTest {

	Chopper chop;
	int[] oneIntArray = {1};
	int[] threeIntArray = {1, 3, 5};
	int[] fourIntArray = {1, 3, 5, 7};

	private void checkChop(int[] anArray, int searchItem, int expected) {
		assertEquals(expected, Chopper.chop(searchItem, anArray));
	}

	@Test
	public void emptyArrayReturnsNegativeOne() {
		int[] anArray = new int[0];
	
		checkChop(anArray, 1, -1);
	}

	@Test
	public void oneIntArrayFoundReturnsZero() {
		checkChop(oneIntArray, 1, 0);
	}

	@Test
	public void oneIntArrayNotFoundReturnsNegativeOne() {
		checkChop(oneIntArray, 3, -1);
	}

	@Test
	public void threeIntArrayFoundReturnsPosition() {
		checkChop(threeIntArray, 1, 0);
		checkChop(threeIntArray, 3, 1);
		checkChop(threeIntArray, 5, 2);
		checkChop(threeIntArray, 0, -1);
		checkChop(threeIntArray, 2, -1);
		checkChop(threeIntArray, 4, -1);
		checkChop(threeIntArray, 6, -1);
	}
	
	@Test
	public void fourIntArrayFoundReturnsPosition() {
		checkChop(fourIntArray, 1, 0);
		checkChop(fourIntArray, 3, 1);
		checkChop(fourIntArray, 5, 2);
		checkChop(fourIntArray, 7, 3);
		checkChop(fourIntArray, 0, -1);
		checkChop(fourIntArray, 2, -1);
		checkChop(fourIntArray, 4, -1);
		checkChop(fourIntArray, 6, -1);
		checkChop(fourIntArray, 8, -1);
	}
	

	
}
