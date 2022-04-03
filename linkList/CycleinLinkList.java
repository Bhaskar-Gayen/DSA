package linkList;

/**LeetCode: 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
*/
public class CycleinLinkList {
	/*Method 1*/	
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false; 
    }
    
    /*Method 2(Using extra space)*/
    

}
