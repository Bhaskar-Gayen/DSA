package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Code Studio: Merge K Sorted Arrays
 * */

class Value{
    int data;
    int col;
    int row;
    Value(int v, int c, int r){
        data=v;col=c;row=r;
    }
}

public class MergeKSortedArrays {
	/*Method-1*/
	public  ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
        ArrayList<Integer> ans=new ArrayList<>();
        //MinHeap create
        Queue<Value> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        
        for(int i=0;i<k;i++){
            int val=kArrays.get(i).get(0);
            pq.add(new Value(val,0,i));
        }
        
        while(!pq.isEmpty()){
            Value temp=pq.remove();
            ans.add(temp.data);
            if(temp.col+1<kArrays.get(temp.row).size()){
                int val=kArrays.get(temp.row).get(temp.col+1);
                pq.add(new Value(val,temp.col+1,temp.row));
            }
        }
        
        return ans;
	}

}
