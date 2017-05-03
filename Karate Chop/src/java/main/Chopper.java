import java.util.stream.IntStream;

public class Chopper {

	Integer[] array;
	Integer searchValue;
	int pointer;
	int position;
	int comparisonResult;
	int highIndex;
	int lowIndex;
	
	public static int chop(int searchValue, int[] intArray) {
		Chopper chop = new Chopper(searchValue, intArray);
		return chop.chop();
	}

	private Chopper(int searchValue, int[] intArray) {
		array =  IntStream.of( intArray ).boxed().toArray( Integer[]::new );
		this.searchValue = searchValue;
		position = -1;
		comparisonResult = 0;
		lowIndex = 0;
		highIndex = intArray.length - 1;
	}

	private int chop() {
		if (array.length > 0)
			do {
				highIndex = valueIsLess() ? pointer - 1 : highIndex;
				lowIndex = valueIsMore() ? pointer + 1 : lowIndex;
				movePointer();
				compareToSearchValue();
				setPointerIfItMaches();
			} while (valueIsMore() || valueIsLess());
		return position;
	}

	private void setPointerIfItMaches() {
		if (comparisonResult == 0)
			position = pointer;
	}

	private boolean valueIsLess() {
		return comparisonResult > 0 && pointer > lowIndex;
	}

	private boolean valueIsMore() {
		return comparisonResult < 0 && pointer < highIndex;
	}

	private void movePointer() {
		pointer = lowIndex + (highIndex - lowIndex) / 2;
	}

	private void compareToSearchValue() {
		comparisonResult = array[pointer].compareTo(searchValue);
	}

}
