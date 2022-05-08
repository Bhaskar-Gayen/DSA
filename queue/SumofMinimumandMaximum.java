package queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**CodingNinja: Sum of minimum and maximum elements of all subarrays of size “K”
 * Input: 5 3
	1 2 3 4 5
 Output: 18
 */

public class SumofMinimumandMaximum {
	
	public static long sumOfMaxAndMin(ArrayList<Integer> arr, int n, int k) {
        //create Dqueue
        LinkedList<Integer> min = new LinkedList<Integer>();
		LinkedList<Integer> max = new LinkedList<Integer>();
        long ans=0;
        
        int i=0;
        for(;i<k;i++){
             while (!max.isEmpty() && arr.get(i) >=arr.get(max.peekLast()))
                max.removeLast();
			while (!min.isEmpty() && arr.get(i) <=arr.get(min.peekLast()))
                min.removeLast();
            max.addLast(i);
			min.addLast(i);
        }
        for(;i<n;i++){
           ans+=arr.get(max.peek())+arr.get(min.peek());
			while ((!max.isEmpty()) && max.peek() <=i - k)
                max.removeFirst();
           while (!max.isEmpty() && arr.get(i) >=arr.get(max.peekLast()))
                max.removeLast();
			while ((!min.isEmpty()) && min.peek() <=i - k)
                min.removeFirst();
			while (!min.isEmpty() && arr.get(i) <=arr.get(min.peekLast()))
                min.removeLast();
            max.addLast(i);
			min.addLast(i);
        }
		ans+=arr.get(max.peek()) +arr.get(min.peek());
		return ans;
    }

}
