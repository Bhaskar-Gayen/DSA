/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int arr[] = {2,4,5,6,8,9,10,17,20};
		int key =17,loc;
		if((loc=binarySearch(arr, 0, arr.length-1, key))==-1)
		    System.out.println("Not found");
		 else
		    System.out.println("Location: "+(loc+1));
	}
	
	
	public static int binarySearch(int arr[], int start, int end, int key){
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
	
}