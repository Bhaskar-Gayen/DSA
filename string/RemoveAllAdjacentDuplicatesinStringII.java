package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 1209. Remove All Adjacent Duplicates in String II
 * Input: s = "abcd", k = 2 Output: "abcd"
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * */

class Pair{
    char ctr;
    int count;
    Pair(char ctr, int count){
        this.ctr=ctr;
        this.count=count;
    }
}

public class RemoveAllAdjacentDuplicatesinStringII {
	
	/*Method-1 T.C-O(N)*/
	public String removeDuplicates2(String s, int k) {
        int len=s.length();
        if(len<=1) return s;
        Stack<Pair> st = new Stack<>();
        for(int i=len-1;i>=0;i--){
            char c=s.charAt(i);
            if(!st.isEmpty()&&st.peek().ctr==c){
                Pair temp=st.peek(); 
                temp.count++;
                if(temp.count==k)
                    st.pop();
            }else
                st.push(new Pair(c,1));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Pair t=st.pop();
            while(t.count!=0){
                sb.append(t.ctr);
                t.count--;
            }
        }
        return sb.toString();
    }
	
    /*Method-1 optimize*/
    public String removeDuplicates(String s, int k) {
         StringBuffer sb = new StringBuffer();
        List<Integer> duplicatesCounts = new ArrayList<Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int curLength = sb.length();
            char c = s.charAt(i);
            int curCount = 1;
            if (curLength > 0 && c == sb.charAt(curLength - 1))
                curCount = duplicatesCounts.get(curLength - 1) + 1;
            if (curCount == k) {
                int startIndex = curLength - k + 1;
                sb.delete(startIndex, curLength);
                for (int j = curLength - 1; j >= startIndex; j--)
                    duplicatesCounts.remove(j);
            } else {
                sb.append(c);
                duplicatesCounts.add(curCount);
            }
        }
        return sb.toString();
    }

}
