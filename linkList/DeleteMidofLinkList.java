package linkList;
/*LeetCode: 2095. Delete the Middle Node of a Linked List*/
public class DeleteMidofLinkList {
	/*Method-1*/
	public ListNode deleteMiddle(ListNode head) {
        //base case
       if(head==null||head.next==null)
           return null;
       if(head.next.next==null){
           head.next=null;
           return head;   
       }
       ListNode slow,fast;
       slow=head;
       fast=head.next;
       while(fast!=null){
           fast=fast.next;
           if(fast!=null)
               fast=fast.next;
           slow=slow.next;
       }
       while(slow.next.next!=null){
           slow.val=slow.next.val;
           slow=slow.next;
       }
       slow.val=slow.next.val;
       slow.next=null;
       return head;
   }

}
