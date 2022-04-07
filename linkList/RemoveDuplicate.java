package linkList;

import java.util.HashSet;

/**
 * LeectCode: 83. Remove Duplicates from Sorted List Input: head = [1,1,2]
 * Output: [1,2]
 */
public class RemoveDuplicate {
	/* method 1 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode start = head;
		ListNode fast = head;
		while (fast != null) {
			if (fast.val != start.val) {
				start.next = fast;
				start = start.next;
			}
			fast = fast.next;
		}
		start.next = null;
		return head;
	}

	/**
	 * LeetCode: 82. Remove Duplicates from Sorted List II Input: head =[1,2,3,3,4,4,5] Output: [1,2,5]
	 */

	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = new ListNode(0);
		temp.next = head;

		ListNode prev = temp;
		ListNode curr = head;

		while (curr != null) {
			boolean dup = false;
			// skip the duplicate value
			while (curr.next != null && curr.next.val == curr.val) {
				curr = curr.next;
				dup = true;
			}
			if (dup)
				prev.next = curr.next;
			else
				prev = curr;
			curr = curr.next;
		}
		return temp.next;
	}
	
	/*CodeNinja: Remove Duplicates From Unsorted Linked List
	 * input: 4 2 5 4 2 2 -1
	 * output: 4 2 5 -1*/
	
	public static ListNode removeDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode nextNode=head.next,prev=head;
        set.add(prev.val);
        while(nextNode!=null){
            if(set.add(nextNode.val)){
                prev.next=nextNode;
                prev=prev.next;
            }
            nextNode=nextNode.next;
            }
         return head;
        }  
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next=new ListNode(2);
		head.next.next=new ListNode(20);
		head.next.next.next=new ListNode(2);
		head.next.next.next.next=null;
		removeDuplicates(head);
		while(head!=null)
			System.out.print(head.val+" ");
	}
}
