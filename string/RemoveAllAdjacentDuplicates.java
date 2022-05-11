package string;

import java.util.Stack;
/**
 * LeetCode:1047. Remove All Adjacent Duplicates In String
 * Input: s = "abbaca" Output: "ca"
 * */

public class RemoveAllAdjacentDuplicates {
	public String removeDuplicates(String s) {
        int len=s.length();
        if(len<=1)
            return s;
        Stack<Character> st = new Stack<>();
        for(int i=len-1;i>=0;i--){
            char c = s.charAt(i);
            if(st.isEmpty()||st.peek()!=c)
                st.push(c);
            else
                st.pop();
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
            ans.append(st.pop());
        return ans.toString();
        
    }

}
