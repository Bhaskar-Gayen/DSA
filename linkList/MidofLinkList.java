package linkList;
/*LeetCode: 876. Middle of the Linked List*/
public class MidofLinkList {
	/*Method-1*/
	public ListNode middleNode(ListNode head) {
        int len = getLenght(head);
        int mid=len/2;
        while(mid>0){
            head=head.next;
            mid--;
        }
        return head;
    }
    static int getLenght(ListNode head){
        int i=0;
        for(;head!=null;i++,head=head.next);
        return i;
    }
    
    /*Method 2*/
    public ListNode middleNode1(ListNode head) {
        //base case
        if(head==null||head.next==null)
            return head;
        if(head.next.next==null)
            return head.next;
        ListNode slow,fast;
        slow=head;
        fast=head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
