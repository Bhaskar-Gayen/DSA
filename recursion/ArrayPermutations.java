package recursion;

import java.util.ArrayList;
import java.util.List;

/**LeetCode: 46. Permutations
 * Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	*/

public class ArrayPermutations {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int index=0;
        solver(nums,ans,index);
        
        return ans;
    }
    
    static void solver(int[] arr, List<List<Integer>> ans, int index){
        //base case
        if(index>=arr.length){
            List<Integer> t = new ArrayList<>();
            for(int i: arr)
                t.add(i);
            ans.add(t);
            return;
        }
        
        //process
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            solver(arr,ans,index+1);
            //Backtrack
            swap(arr,i,index);
        }
    }
    
    static void swap(int[] arr, int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}
