package stack;

import java.util.Stack;

public class DeleteMiddleElement {
	
	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		int count=1;
		int size=inputStack.size();
		deleteMid(inputStack, count, size);
		
	}
	static void deleteMid(Stack<Integer> inputStack, int count, int size){
		if(size==1){
			inputStack.pop();
			return;
		}
		
		if(count==(int)Math.ceil(size/2.0)){
			inputStack.pop();
			return;
		}
		int key=inputStack.pop();
		deleteMid(inputStack, count+1, size);
		inputStack.push(key);
	}

}
