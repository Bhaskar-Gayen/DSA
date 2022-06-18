package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Code Studio: Median in a stream
 * Input: 3
 * 5 3 8
 * Output: 5 4 5
 * */

public class MedianInStream {
	
	 int[] findMedian(int[] arr, int n) {
        int[] ans=new int[n];
        if(arr.length==1)
            return arr;
        //Min Heap
        Queue<Integer> minHeap=new PriorityQueue<>();
        //Max Heap
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int median=-1;
        for(int i=0;i<n;i++){
            median=findMedian(arr[i],maxHeap,minHeap,median);
            ans[i]=median;
        }
        return ans;
    }
   int  findMedian(int element, Queue<Integer>maxHeap, Queue<Integer>minHeap, int median){
        switch(signal(maxHeap.size(),minHeap.size())){
            case 0:
                if(element>median){
                    minHeap.add(element);
                    median=minHeap.peek();
                }
                else{
                    maxHeap.add(element);
                    median=maxHeap.peek();
                }
                break;
            case 1:
                if(element>median){
                    minHeap.add(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                else{
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                break;
            case -1:
                if(element>median){
                    maxHeap.add(minHeap.remove());
                    minHeap.add(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                else{
                    maxHeap.add(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                break;
        }
        return median;
    }
     int signal(int a, int b){
        return a==b?0:((a>b)?1:-1);
    }

}
