package stack;

import java.util.ArrayList;
import java.util.Stack;

/**Coding Ninja: Next Smaller Element
 * input: [1 2 3 4]
 * output: [-1 -1 -1 -1]*/

public class NextSmallerElement {
	
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for(int index=n-1;index>=0;index--){
			int val = arr.get(index);
			arr.remove(index);
			arr.add(index, findMin(stack,val));
			stack.push(val);
		}
		return arr;
    }
	static int findMin(Stack<Integer> stack, int key){
		while(!stack.isEmpty()&&stack.peek()>=key)
			stack.pop();
		return stack.peek();
	}

}
