package array;

public class ZeroOneTwoSort {
	
	 void dnfSorting(int[] arr){
        if(arr==null||arr.length<=1)
         return;
        int low=0, mid=0, high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;mid++;
            }
            else
                if(arr[mid]==1) mid++;
                else
                   {
                       swap(arr,mid,high);
                       high--;
                   }
        
        }
    }
	 void swap(int[] arr, int i, int j){
        if(i<0||j>arr.length-1)
        return;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
