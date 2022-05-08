package stack;

import java.util.Stack;

/**
 * LeetCode: 84. Largest Rectangle in Histogram
 * Input: heights = [2,1,5,6,2,3] Output: 10
 * */

public class LargestRectangleinHistogram {
	
	public int largestRectangleArea(int[] heights) {
        int length=heights.length;
        int[] next=nextSmallerElementIndex(heights,length);
        int[] prev=prevSmallerElementIndex(heights,length);
        int area=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            int l=heights[i];
            if(next[i]==-1)
                next[i]=length;
            int b=next[i]-prev[i]-1;
            int newArea=l*b;
            area=Math.max(area,newArea);
        }
        return area;
        
    }
    
    int[] nextSmallerElementIndex(int[] heights, int length){
        int[] ans= new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=length-1;i>=0;i--){
            int curr=heights[i];
            while(stack.peek()!=-1&&heights[stack.peek()]>=curr)
                stack.pop();
            ans[i]=stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    int[] prevSmallerElementIndex(int[] heights, int length){
        int[] ans= new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<length;i++){
            int curr=heights[i];
            while(stack.peek()!=-1&&heights[stack.peek()]>=curr)
                stack.pop();
            ans[i]=stack.peek();
            stack.push(i);
        }
        return ans;
    }

}
