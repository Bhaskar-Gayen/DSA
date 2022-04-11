package stack;

import java.util.Stack;

public class ValidParentheses {
	
	 public boolean isValid(String s) {
	        Stack<Character> stack= new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if(c=='}'||c==']'||c==')'){
	                if(!stack.isEmpty()){
	                    char top=stack.peek();
	                    if((c=='}'&&top=='{')||(c==')'&&top=='(')||(c==']'&&top=='['))
	                        stack.pop();
	                    else
	                        return false;
	                }else
	                    return false;
	            }else
	                stack.push(c);
	        }
	        return stack.isEmpty()==true;
	    }

}
