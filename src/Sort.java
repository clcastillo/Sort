import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sort {
	static Random rand = new Random(42);
	static int arr10[] = { 11, 299, 9, 4, 6, 3, 443, 5, 1 };
	
	static int countMove;
	static int countCompare;
	public static void main(String[] args) {
		//int arr10[] = createRandomArray(10);
		int arr100[] = createRandomArray(100);
		int arr1000[] = createRandomArray(1000);
		int arrayMethod[];
		int i = 0;
		System.out.println("What method do you want to use ");	
		System.out.println();
		System.out.println("Choice 1:Selective Sort Iterative \nChoice 2:Selective Sort Recursion ");
		System.out.println("Choice 3:Insertion Sort Iterative \nChoice 4:Insertion Sort Recursion ");
		System.out.println("Choice 5:Shell Sort Iterative \nChoice 6:Shell Sort Recursion ");
		System.out.println("Choice 7:Merge Sort Iterative \nChoice 8:Merge Sort Recursion ");
		System.out.println("Choice 9:Quick Sort Iterative \nChoice 10:Quick Sort Recursion ");
		System.out.println("Choice 11:Radix Sort Iterative \nChoice 12:Radix Sort Recursion ");

		Scanner keyboard = new Scanner(System.in);
		int userChice = keyboard.nextInt();
		switch (userChice) {
		case 1:
			arrayMethod = doSelectionSort(arr10);
			for (int x : arrayMethod) {
				System.out.println(i + ". " + x);
				i++;
			}
			break;
		case 2:
			arrayMethod = recursiveSelectionSort(arr10, 0);
			for (int x : arrayMethod) {
				System.out.println(i + ". " + x);
				i++;
			}
			break;
		case 3:
			arrayMethod = doInsertionSort(arr10);
			for (int x : arrayMethod) {
				System.out.println(i + ". " + x);
				i++;
			}
			break;
		case 4:
			sort(arr10.length);
			print(arr10);

			break;
		case 5:
			arrayMethod = bothShellSort(arr10);
			for (int x : arrayMethod) {
				System.out.println(i + ". " + x);
				i++;
			}
			break;
		case 6:
			arrayMethod=ShellSortRecursive(arr10,2);
			print(arr10);

			break;
		case 7:
			arrayMethod = mergeSort(arr10);
			for (int x : arrayMethod) {
				System.out.println(i + ". " + x);
				i++;
			}
			break;
		case 8:
			recursiveMergesort(arr10);
			print(arr10);

			break;
		case 9:
			quickSortLast(arr10, 0, arr10.length - 1);
			print(arr10);

			break;
		case 10:
			arrayMethod =QuickSortRecursive(arr10,0, arr10.length-1);
			for (int x : arrayMethod) {
				System.out.println(i + "-- " + x);
				i++;
			}

			break;
		case 11:
			RadixSort(arr10);
			print(arr10);

			break;
		case 12:
			RadixRecursiveSort(arr10, arr10.length-1) ;
			print(arr10);
			break;
		}
	}

	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(100);
		}
		return a;
	}

	public static int[] doSelectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index_min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index_min]) {
					index_min = j;
				}
				countCompare++;
			}
			swapNumbers(arr, i, index_min);
			countMove++;
		}
		return arr;
	}

	private static void swapNumbers(int[] arr, int i, int index) {
		int smallerNumber = arr[index];
		arr[index] = arr[i];
		arr[i] = smallerNumber;
	}

	// plug in index starting point, from where you want to organize the array
	public static int[] recursiveSelectionSort(int[] arr, int n) {
		if (n == arr.length - 1) {
			return arr;
		}
		int temp, lowestIndex = n;
		for (int i = n + 1; i < arr.length; i++) {
			if (arr[i] < arr[lowestIndex]) {
				lowestIndex = i;
			}
		}
		temp = arr[n];
		arr[n] = arr[lowestIndex];
		arr[lowestIndex] = temp;
		return recursiveSelectionSort(arr, n + 1);
	}

	// works doInsert
	public static int[] doInsertionSort(int[] input) {
		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		countCompare++;
		return input;
	}

	public static int sort(int maxIndex) {
		if (maxIndex <= 1) {
			return maxIndex;
		}

		maxIndex = sort(maxIndex - 1);

		int key = arr10[maxIndex];

		int i = maxIndex - 1;

		while ((i >= 0) && (arr10[i] > key)) {
			arr10[i + 1] = arr10[i];
			i--;
		}
		arr10[i + 1] = key;
		return maxIndex + 1;
	}

	private static void print(int[] arr) {
		System.out.println();
		int j=0;
		for (int i : arr) {
			System.out.println(j+". "+i);
			j++;
		}
	}

	// works
	public static int[] bothShellSort(int[] a) {
		int j;
		int temp;
		int i;

		int inc = 1;
		int k = 0;
		while (inc <= a.length + 1) {
			for (i = inc; i <= a.length - 1; i++) {
				temp = a[i];
				j = i;
				while (j >= inc && a[j - inc] > temp) {
					a[j] = a[j - inc];
					j = j - inc;
				}
				a[j] = temp;
			}
			k = k + 1;
			inc = (int) (java.lang.Math.pow(2, k)) - (int) 1;
		}

		return a;
	}

	int i = 0;

	public static int[] ShellSortRecursive(int[] array, int i) {
		if (i == array.length - 1)
			return array;
		else if (i < array.length - 1) {

			bothShellSort(array);
			ShellSortRecursive(array, i + 1);
		}
		int[] empty = {};
		return empty;

	}

	// yes merge sort works use tthis one
	public static int[] mergeSort(int[] a) {
		if (a.length >= 2) {
			int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			mergeSort(left);
			mergeSort(right);
			countMove++;
			int i1 = 0;
			int i2 = 0;
			for (int i = 0; i < a.length; i++) {
				if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
					a[i] = left[i1];
					i1++;
				} else {
					a[i] = right[i2];
					i2++;
				}
			}
		}
		return a;
	}

	static public int[] DoMerge(int[] numbers, int left, int mid, int right) {
		int[] temp = new int[numbers.length];
		int i, left_end, num_elements, tmp_pos;

		left_end = (mid - 1);
		tmp_pos = left;
		num_elements = (right - left + 1);

		while ((left <= left_end) && (mid <= right)) {
			if (numbers[left] <= numbers[mid])
				temp[tmp_pos++] = numbers[left++];
			else
				temp[tmp_pos++] = numbers[mid++];
		}

		while (left <= left_end)
			temp[tmp_pos++] = numbers[left++];

		while (mid <= right)
			temp[tmp_pos++] = numbers[mid++];

		for (i = 0; i < num_elements; i++) {
			numbers[right] = temp[right];
			right--;
		}
		return numbers;
	}

	static public void MergeSort_Recursive(int[] numbers, int left, int right) {
		int mid;

		if (right > left) {
			mid = (right + left) / 2;
			MergeSort_Recursive(numbers, left, mid);
			MergeSort_Recursive(numbers, (mid + 1), right);

			DoMerge(numbers, left, (mid + 1), right);
		}
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		countCompare++;
		if (mid >= a.length)
			return;
		if (hi > a.length)
			hi = a.length;
		int i = lo, j = mid;
		for (int k = lo; k < hi; k++) {
			if (i == mid)
				aux[k] = a[j++];
			else if (j == hi)
				aux[k] = a[i++];
			else if (a[j] < a[i])
				aux[k] = a[j++];
			else
				aux[k] = a[i++];
		}
		for (int k = lo; k < hi; k++)
			a[k] = aux[k];
	}
//need
	public static void recursiveMergesort(int[] a, int[] aux, int lo, int hi) {
		if (hi - lo <= 1)
			return;
		int mid = lo + (hi - lo) / 2;
		recursiveMergesort(a, aux, lo, mid);
		recursiveMergesort(a, aux, mid, hi);
		merge(a, aux, lo, mid, hi);
	}
//need
	public static void recursiveMergesort(int[] a) {
		int n = a.length;
		int[] aux = new int[n];
		recursiveMergesort(a, aux, 0, n);
	}

	private static void quickSortLast(int[] a, int min, int max) {
		if (min >= max) {
			return;
		}

		int pivot = a[min];

		swap(a, min, max);

		int i = min;
		int j = max - 1;
		while (i <= j) {
			while (i <= j && a[i] < pivot) {
				i++;
			}
			while (i <= j && a[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}

		swap(a, max, i);

		quickSort(a, min, i - 1);
		quickSort(a, i + 1, max);
	}

	private static void quickSort(int[] a, int min, int max) {
		if (min >= max) {
			return;
		}

		int pivot = a[min];

		swap(a, min, max);

		int i = min;
		int j = max - 1;
		while (i <= j) {
			while (i <= j && a[i] < pivot) {
				i++;
			}
			while (i <= j && a[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}

		swap(a, max, i);

		quickSort(a, min, i - 1);
		quickSort(a, i + 1, max);
	}

	private static final void swap(int[] a, int i, int j) {
		countCompare++;
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	public static int[] QuickSortRecursive(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = Partition(arr, left, right);

			if (pivot > 1)
				QuickSortRecursive(arr, left, pivot - 1);

			if (pivot + 1 < right)
				QuickSortRecursive(arr, pivot + 1, right);
		}
		return arr;
	}

	/*
	 * private void quickSort(int[] array, int min, int max) { if (min > max) {
	 * return; } int pivot = Partition(array, min, max);
	 * 
	 * quickSort(array, min, pivot - 1); quickSort(array, pivot + 1, max); }
	 
*/
	public static int Partition(int[] numbers, int left, int right) {
		countCompare++;
		int pivot = numbers[left];
		while (true) {
			while (numbers[left] < pivot)
				left++;

			while (numbers[right] > pivot)
				right--;

			if (left < right) {
				int temp = numbers[right];
				numbers[right] = numbers[left];
				numbers[left] = temp;
			} else {
				return right;
			}
		}
	}
	public static void RadixSort( int[] array)
    {
        int i, m = array[0], exp = 1, n = array.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++)
            if (array[i] > m)
                m = array[i];
        while (m / exp > 0)
        {countCompare++;
            int[] numbers = new int[10];
 
            for (i = 0; i < n; i++)
                numbers[(array[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                numbers[i] += numbers[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--numbers[(array[i] / exp) % 10]] = array[i];
            for (i = 0; i < n; i++)
                array[i] = b[i];
            exp *= 10;     
            countCompare++;
        }
    }
	public static int[] RadixRecursiveSort(int[] numbers, int digit) {

	     if (numbers.length == 0 || digit <= 0)
	           return numbers;

	     int[][]space = new int[10][1];
	     int[] len = new int[10];
	     int i, j = 0;

	      for (j = 0; j < numbers.length; j++) {
	            i = (numbers[j] / digit) % 10;
	            len[i]++;
	            space[i] = putInBucket(space[i], numbers[j]);
	      }


	      for (i = 0; i < 10; i++) {
	          int[] bucket = new int[len[i]];
	          for (int k = 0; k < len[i]; k++) 
	              bucket[k] = space[i][k];
	          space[i] = RadixRecursiveSort(bucket, digit / 10); 
	      }

	      int k = 0;

	      for (i = 0; i < 10; i++) {
	          for (j = 0; j < len[i]; j++) {
	              numbers[k] = space[i][j];
	              k++;
	          }
	      }

	      return numbers; 

	}

	private static int[] putInBucket(int[] array, int number) {

	    int[] bucket_new = new int[array.length+1];


	    for (int i = 1; i < bucket_new.length; i++) {
	        bucket_new[i] = array[i-1];
	    }
	    bucket_new[0] = number;

	    return bucket_new;

	}
	
	
}