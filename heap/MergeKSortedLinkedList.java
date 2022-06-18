package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Code Studio: Merge k sorted lists Given 'K' sorted linked lists, each list is
 * sorted in increasing order. You need to merge all these lists into one single
 * sorted list. You need to return the head of the final linked list.
 */

class LinkedListNode<T> {
	int data;
	LinkedListNode<T> next;

	public LinkedListNode(int data) {
		this.data = data;
	}
}

public class MergeKSortedLinkedList {

	public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
		int k = listArray.length;

		LinkedListNode<Integer> ans = new LinkedListNode<Integer>(-1);
		LinkedListNode<Integer> pos = ans;
		// create minHeap
		Queue<LinkedListNode<Integer>> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
		for (int i = 0; i < k; i++) {
			if (listArray[i] != null)
				pq.add(listArray[i]);
		}
		while (!pq.isEmpty()) {
			LinkedListNode<Integer> temp = pq.remove();
			pos.next = temp;
			pos = pos.next;
			if (temp.next != null)
				pq.add(temp.next);
		}
		return ans.next;
	}

}
