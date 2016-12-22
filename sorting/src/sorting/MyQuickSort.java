package sorting;

/* http://www.java2novice.com/java-sorting-algorithms/quick-sort/ */

public class MyQuickSort {
	private int[] array;

	public void sort(int[] arr) {
		this.array = arr;

		long startTimeInMillis = System.nanoTime();

		quickSort(0, this.array.length - 1);

		long endTimeInMillis = System.nanoTime();
		System.out.println("QuickSort speed for an array with " + arr.length
				+ " elements is " + (endTimeInMillis - startTimeInMillis));

	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;

		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

		while (i <= j) {
			while (this.array[i] < pivot) {
				i++;
			}

			while (this.array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = this.array[i];
				this.array[i] = this.array[j];
				this.array[j] = temp;
				i++;
				j--;
			}
		}

		if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
	}
	
	protected void printArray() {
		StringBuilder arrayAsStringBuilder = new StringBuilder();
		arrayAsStringBuilder.append("{ ");

		for (int element : this.array) {
			arrayAsStringBuilder.append(element + " ");
		}

		arrayAsStringBuilder.append("}");

		System.out.println(arrayAsStringBuilder.toString());
	}
}
