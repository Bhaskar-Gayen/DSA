package stack;

import java.util.Stack;

public class RedundantBrackets {
	 public static boolean findRedundantBrackets(String s) 
		{
		 if(s.length()==1)
			 return true;
		 
			Stack<Character> stack=new Stack<>();
			for(int i=0;i<s.length();i++){
				char c=s.charAt(i);
				if(c=='('||isOperator(c)){
					stack.push(c);
				}else{
					if(c==')'){
						boolean flag=true;
						while(stack.peek()!='('){
							if(isOperator(stack.peek()))
								flag=false;
							stack.pop();
						}
						if(flag)
							return true;
						stack.pop();
					}
				}
			}
			return false;
	    }
		static boolean isOperator(char c){
			return c=='+'||c=='-'||c=='/'||c=='*';
		}

}
