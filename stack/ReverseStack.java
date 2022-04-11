package stack;

import java.util.Stack;

public class ReverseStack {
	
	public static void reverseStack(Stack<Integer> stack) {
		//base case
		if(stack.isEmpty())
			return;
		int val = stack.pop();
		//Recursion call
		reverseStack(stack);
		insertButtom(stack,val);
	} 
	
	static void insertButtom(Stack<Integer> stack, Integer val){
		if(stack.isEmpty()){
			stack.push(val);
			return;
		}
		int key = stack.pop();
		insertButtom(stack, val);
		stack.push(key);
	}


}
