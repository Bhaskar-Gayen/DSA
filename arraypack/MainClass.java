package arraypack;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	
	/* Maximum array sum from both end of a array */
	public int maxSumEnd(ArrayList<Integer> A, int B){
	 int sumsofer=0;
	    for(int i=0;i<B;i++)
	        sumsofer+=(int)A.get(i);
	    int f=B-1, r=A.size()-1;
	    int maxsum=sumsofer;
	    while(f>=0&&r>=0){
	        sumsofer+=(int)A.get(r--);
	        sumsofer-=(int)A.get(f--);
	        maxsum=Math.max(sumsofer,maxsum);
	    }
	    return maxsum;
	}
	
	/* Binary Search in an Array Iterative Method*/ 
	public  int binarySearch(int arr[], int start, int end, int key){
	    if(arr==null) return 0;
	    if(start<=end){
	    int mid = (start+end)/2;
	    
	    if(arr[mid]==key) return mid;
	    else{
	        if(arr[mid]>key)
	        end=mid-1;
	        else
	            start=mid+1;
	     return  binarySearch(arr, start, end, key);
	    }
	    }
	    return -1;
	}
	/* Find one single duplicate element from an array*/
	public  int finDuplicate(int arr[]){
	    int ans = arr[0];
	    for(int i=1;i<arr.length;i++)
	        ans ^= arr[i];
	   for(int i=1;i<arr.length;i++)
	    ans ^= i;
	   return ans;
	}
	
	/* Find list of Duplicate elements from an array */
	 public  List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            int abs_val = Math.abs(arr[i]);
            if(arr[abs_val-1]>0)
                arr[abs_val-1]=-arr[abs_val-1];
            else
                list.add(abs_val);
        }
        return list;
    }

}
