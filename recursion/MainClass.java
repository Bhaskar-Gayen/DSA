package recursion;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	
	/*LeetCode: 17. Letter Combinations of a Phone Number 
	 * Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"] */
	
	public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int index=0;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solver(digits,ans,str,index,map);
        return ans;
    }
    static void solver(String digits, List<String> ans, StringBuilder str, int index, String[] map){
        //base case
        if(index>=digits.length()){
            ans.add(str.toString());
            return;
        }
        //process
        int d=digits.charAt(index)-'0';
        String val=map[d];
        for(int i=0;i<val.length();i++){
            StringBuilder temp=new StringBuilder(str);
            temp.append(val.charAt(i));
            solver(digits,ans,temp,index+1,map);
            temp=null;
        }
    }

}
