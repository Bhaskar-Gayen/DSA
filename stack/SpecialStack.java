package stack;

import java.util.Stack;

/**
 * CodingNinja: Design a stack that supports getMin() in O(1) time and O(1) extra space*/

public class SpecialStack {
	private Stack<Integer> stack=new Stack<>();
	private int min=Integer.MAX_VALUE;
	void push(int data) {
		if(stack.isEmpty()){
			stack.push(data);
			min=data;
		}
		else{
			if(data<min){
				stack.push(data*2-min);
				min=data;
			}else
				stack.push(data);
		}
	}

	int pop() {
		if(isEmpty())
			return -1;
		int curr=stack.pop();
		if(curr>min)
			return curr;
		else{
			int prevMin=min;
			min=2*min-curr;
			return prevMin;
		}
	}

	int top() {
		if(isEmpty())
			return -1;
		if(stack.peek()<min)
			return min;
		else
			return stack.peek();
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

	int getMin() {
		if(isEmpty())
			return -1;
		return min;
	}
}
