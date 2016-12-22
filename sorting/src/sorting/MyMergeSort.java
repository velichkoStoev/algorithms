package sorting;

/* http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html */

public class MyMergeSort {
	private int[] array;
	private int[] helperArray;

	public void sort(int[] arr) {
		this.array = arr;
		this.helperArray = new int[arr.length];
		
		long startTimeInMillis = System.nanoTime();

		mergeSort(0, arr.length - 1);

		long endTimeInMillis = System.nanoTime();
		System.out.println("MergeSort speed for an array with " + arr.length
				+ " elements is " + (endTimeInMillis - startTimeInMillis));
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			this.helperArray[i] = this.array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (this.helperArray[i] <= this.helperArray[j]) {
				this.array[k] = this.helperArray[i];
				i++;
			} else {
				this.array[k] = this.helperArray[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle){
			this.array[k] = this.helperArray[i];
			k++;
			i++;
		}
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
