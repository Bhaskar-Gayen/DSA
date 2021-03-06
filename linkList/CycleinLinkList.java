package linkList;

import java.util.HashSet;
import java.util.Set;

/**LeetCode: 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
*/
public class CycleinLinkList {
	/*Method 1(Floyd Cycle Detection Algorithm)*/	
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
    public boolean hasCycle1(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        Set<ListNode> hs = new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(hs.contains(temp))
                return true;
            hs.add(temp);
            temp=temp.next;
        }
        return false;
    }
    
    /* Method 1: return starting node of a cycle in a link list */ 
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
           return null;
       Set<ListNode> hs = new HashSet<>();
       ListNode temp=head;
       while(temp!=null){
           if(hs.contains(temp))
               return temp;
           hs.add(temp);
           temp=temp.next;
       }
       return null;
   }
    
    /*Method 2: return starting node of a cycle in a link list */
    public ListNode detectCycle2(ListNode head) {
        if(head==null||head.next==null)
           return null;
       ListNode slow=head;
       ListNode fast= cycle(head);
       if(fast!=null){
            while(slow!=fast){
           slow=slow.next;
           fast=fast.next;
                }
           return slow;
       }
       return null;
       
   }
   
   static ListNode cycle(ListNode head){
       if(head==null||head.next==null)
           return null;
       ListNode slow=head,fast=head;
       while(fast!=null&&fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(slow==fast)
               return fast;
       }
       return null;
   }
   
   /* Remove Cycle from Link List */
   ListNode removeLoop(ListNode head) {
	      if(head==null || head.next==null)
	            return null;
	      ListNode start=detectCycle2(head);
	      ListNode temp=start;
	      if(temp!=null){
	         while(temp.next!=start)
	           temp=temp.next;
	        temp.next=null;
	      }     
	      return head;
	  }
   

}
