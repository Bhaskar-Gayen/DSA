package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
	
	int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=l;i<=r;i++){
            pq.add(arr[i] );
            if(pq.size()>k )
                pq.poll();
        }
        
        return pq.peek();
    } 
	

}
