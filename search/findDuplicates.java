/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    int arr[] = {4,3,2,7,8,2,3,1};
	    List<Integer> res = findDuplicates(arr);
	    System.out.println(res);
		
	}
	
	public static int finDuplicate(int arr[]){
	    int ans = arr[0];
	    for(int i=1;i<arr.length;i++)
	        ans ^= arr[i];
	   for(int i=1;i<arr.length;i++)
	    ans ^= i;
	   return ans;
	}
	
	 public static List<Integer> findDuplicates(int[] arr) {
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