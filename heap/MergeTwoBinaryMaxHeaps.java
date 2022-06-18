package heap;

/**
 * GFG:Merge two binary Max heaps 
 * Input : n = 4 m = 3 a[] = {10, 5, 6, 2}, b[] ={12, 7, 9} 
 * Output : {12, 10, 9, 2, 5, 7, 6}
 */

public class MergeTwoBinaryMaxHeaps {

	public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
		// step1: merge two array
		int[] ans = new int[n + m];
		System.arraycopy(a, 0, ans, 0, n);
		System.arraycopy(b, 0, ans, n, m);

		// step2: build heap on that array
		buildHeap(ans);

		return ans;
	}

	void buildHeap(int[] arr) {
		// int heapSize=arr.length-1;
		for (int i = arr.length / 2; i >= 0; i--)
			maxHeapify(arr, i);
	}

	void maxHeapify(int[] arr, int index) {
		int l = 2 * index + 1;
		int r = 2 * index + 2;
		int largest = -1;
		if (l <= arr.length - 1 && arr[l] > arr[index])
			largest = l;
		else
			largest = index;
		if (r <= arr.length - 1 && arr[r] > arr[largest])
			largest = r;
		if (largest != index) {
			swap(arr, index, largest);
			maxHeapify(arr, largest);
		}

	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
