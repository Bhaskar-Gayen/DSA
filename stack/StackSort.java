package stack;

import java.util.Stack;

public class StackSort {
	
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		int val = stack.pop();
		sortStack(stack);
		insertSortedOrder(stack, val);
	}
	static void insertSortedOrder(Stack<Integer> stack, int val){
		if(stack.isEmpty()||stack.peek()<val){
			stack.push(val);
			return;
		}
		int key = stack.pop();
		insertSortedOrder(stack,val);
		stack.push(key);
	}

}
