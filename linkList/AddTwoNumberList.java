package linkList;
/***LeetCode: 2. Add Two Numbers
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * */
public class AddTwoNumberList {
	/*Method 1*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans=new ListNode(-1), temp=ans;
        while(l1!=null||l2!=null){
            int v1= l1==null? 0:l1.val;
            int v2= l2==null?0:l2.val;
            carry+=v1+v2;
            temp.next=new ListNode(carry%10);
            temp=temp.next;
            temp.next=null;
            carry/=10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
            temp.next.next=null;
        }

        return ans.next;     
    }
	
	/*GFG: Add two numbers represented by linked lists */
	static ListNode addTwoLists(ListNode first, ListNode second){
        ListNode l1=reverse(first);
        ListNode l2=reverse(second);
       
       int carry=0;
        ListNode ans=new ListNode(-1), temp=ans;
        while(l1!=null||l2!=null){
            int v1= l1==null? 0:l1.val;
            int v2= l2==null?0:l2.val;
            carry+=v1+v2;
            temp.next=new ListNode(carry%10);
            temp=temp.next;
            temp.next=null;
            carry/=10;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
            temp.next.next=null;
        }
        return reverse(ans.next);
    }
   static ListNode reverse(ListNode head){
        if(head==null|| head.next==null)
            return head;
        ListNode prev=null, curr=head, nextNode=head;
        while(nextNode!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
}
