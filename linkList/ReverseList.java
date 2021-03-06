package linkList;

/*LeetCode: 206. Reverse Linked List*/
public class ReverseList {
	  //Iterative way to reverse a LinkList.
		public ListNode reverseList(ListNode head) {
	        //handle base case
	        if(head==null||head.next==null)
	            return head;
	        ListNode prev, curr, nextNode;
	        prev=null;
	        curr=head;
	        while(curr!=null){
	            nextNode=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=nextNode;
	        } 
	        return prev;
		}
		
		//Recursive way to reverse a LinkList.
		public ListNode reverseListRecursion(ListNode head) {
	        //handle base case
	        if(head==null||head.next==null)
	            return head;
	        ListNode newhead = reverseListRecursion(head.next);
	        head.next.next=head;
	        head.next=null;
	        return newhead;
	    }
		
		

}
