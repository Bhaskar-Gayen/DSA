package queue;

import java.util.Queue;

public class ReverseQueue {
	
	public Queue<Integer> reverse(Queue<Integer> q){
        if(q.isEmpty())
            return q;
        int key=q.remove();
        q = reverse(q);
        q.add(key);
        return q;
    }

}
