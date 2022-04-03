package linkList;

/*LeetCode: 25. Reverse Nodes in k-Group
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/
public class ReverseKGroup {
	/* Method 1 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// base case
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode nextNode = null, temp = head;
		int count = k;
		// Check for k node;
		while (temp != null && count > 0) {
			temp = temp.next;
			count--;
		}
		if (count != 0)
			return head;
		while (curr != null && count < k) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
			count++;
		}
		if (nextNode != null)
			head.next = reverseKGroup(nextNode, k);
		return prev;
	}

}
