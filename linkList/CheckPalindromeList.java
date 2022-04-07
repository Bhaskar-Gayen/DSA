package linkList;
/**LeetCode: 234. Palindrome Linked List
 *Input: head = [1,2,2,1] Output: true
 * */
public class CheckPalindromeList {
	
	public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode mid = getMid(head);
        ListNode dumm=new ListNode(-1);
        dumm.next=null;
        ListNode curr=mid.next;
        ListNode nextNode=curr;
        while(nextNode!=null){
            nextNode=curr.next;
            curr.next=dumm.next;
            dumm.next=curr;
            curr=nextNode;
        } 
        ListNode temp=dumm.next,start=head;
        while(temp!=null){
            if(start.val!=temp.val)
                return false;
            temp=temp.next;
            start=start.next;
        }
        return true;
        
    }
    
    ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=slow.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
