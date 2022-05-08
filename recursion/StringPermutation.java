package recursion;

import java.util.ArrayList;
import java.util.Collections;

/**Code Studio: Permutations of a String
 * input: xyz
 * output: xyz xzy yxz yzx zxy zyx */

public class StringPermutation {
	

	public static ArrayList<String> generatePermutations(String str) {
		StringBuilder input=new StringBuilder(str);
        ArrayList<String> ans = new ArrayList<>();
        int index=0;
        solver(input,ans,index);
        Collections.sort(ans);
        return ans;
	}
    static void solver(StringBuilder str, ArrayList<String> ans, int index){
        //base case
        if(index>=str.length()){
            ans.add(str.toString());
            return;
        }
        //process
        for(int i=index;i<str.length();i++){
            swap(str,i,index);
            solver(str,ans,index+1);
            //backtrack
            swap(str,i,index);
        }
        
    }
    static void swap(StringBuilder str, int index, int i){
        char c = str.charAt(index);
        str.setCharAt(index,str.charAt(i));
        str.setCharAt(i,c);
    }
	

}
