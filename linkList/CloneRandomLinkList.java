package linkList;

import java.util.HashMap;

public class CloneRandomLinkList {
	
	/*Method 1 without Extra Space*/
	public Node copyRandomList(Node head) {
        Node clone=null;
        if(head==null)
            return clone;
       
        Node curr=head;
        while(curr!=null){
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        
        //Update random pointer
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
            curr.next.random=curr.random.next;
            else
                curr.next.random=null;
            curr=curr.next.next;
        }
        
        //cut the link and make original list
        curr=head;
        clone=head.next;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=temp.next;
            curr=curr.next;
            if(curr!=null)
                temp.next=curr.next;
            else
                temp.next=null;
        }
        
        return clone;
        
    }
    
	/*Method 2 with Extra Space*/
     public Node copyRandomList2(Node head) {
        Node clone=null;
        if(head==null)
            return clone;
       
        //copy the original list
        Node origin=head.next;
        clone= new Node(head.val);
        Node copy=clone;
        while(origin!=null){
            copy.next=new Node(origin.val);
            copy=copy.next;
            origin=origin.next;
        }
        copy.next=null;
        //mapping old with new list
        HashMap<Node,Node> map =new HashMap<>();
        copy=clone;
        origin=head;
        while(origin!=null){
            map.put(origin,copy);
            copy=copy.next;
            origin=origin.next;
        }
        
        //fill the random pointer
        copy=clone;
        origin=head;
        while(origin!=null){
            Node rand=map.get(origin.random);
            copy.random=rand;
            copy=copy.next;
            origin=origin.next;
        }
        
        return clone;
        
    }

}
