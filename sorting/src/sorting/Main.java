package sorting;

public class Main {

	public static void main(String[] args) {
		int[] array = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12, 24, 2, 45, 20, 56, 71, 3, 26, 919, 553, 15, 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12, 24, 2, 45, 20, 56, 71, 3, 26, 919, 553, 12 };
		bubbleSort(array.clone());
		insertionSort(array.clone());
		selectionSort(array.clone());

		MyQuickSort quickSort = new MyQuickSort();
		quickSort.sort(array.clone());
		quickSort.printArray();
		
		MyMergeSort mergeSort = new MyMergeSort();
		mergeSort.sort(array.clone());
		mergeSort.printArray();
	}

	private static void printArray(int[] arr) {
		StringBuilder arrayAsStringBuilder = new StringBuilder();
		arrayAsStringBuilder.append("{ ");

		for (int element : arr) {
			arrayAsStringBuilder.append(element + " ");
		}

		arrayAsStringBuilder.append("}");

		System.out.println(arrayAsStringBuilder.toString());
	}

	private static void bubbleSort(int[] arr) {
		long startTimeInMillis = System.nanoTime();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

		long endTimeInMillis = System.nanoTime();
		System.out.println("Bubble sort speed for an array with " + arr.length
				+ " elements is " + (endTimeInMillis - startTimeInMillis));

		printArray(arr);
	}

	private static void insertionSort(int[] arr) {
		long startTimeInMillis = System.nanoTime();

		for (int i = 1; i < arr.length; i++) {
			int valueToInsert = arr[i];
			int insertPosition = i;

			while (insertPosition > 0
					&& arr[insertPosition - 1] > valueToInsert) {
				arr[insertPosition] = arr[insertPosition - 1];
				insertPosition -= 1;
			}

			arr[insertPosition] = valueToInsert;
		}

		long endTimeInMillis = System.nanoTime();
		System.out.println("Insertion sort speed for an array with "
				+ arr.length + " elements is "
				+ (endTimeInMillis - startTimeInMillis));

		printArray(arr);
	}

	private static void selectionSort(int[] arr) {
		long startTimeInMillis = System.nanoTime();

		for (int i = 0; i < arr.length; i++) {
			int currentMinimumValuePosition = i;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[currentMinimumValuePosition]) {
					currentMinimumValuePosition = j;
				}
			}

			int temp = arr[currentMinimumValuePosition];
			arr[currentMinimumValuePosition] = arr[i];
			arr[i] = temp;

		}

		long endTimeInMillis = System.nanoTime();
		System.out.println("Selection sort speed for an array with "
				+ arr.length + " elements is "
				+ (endTimeInMillis - startTimeInMillis));

		printArray(arr);
	}

}
