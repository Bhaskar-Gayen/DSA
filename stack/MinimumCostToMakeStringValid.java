package stack;
/** Coding Ninja:Minimum Cost To Make String Valid 
 * input:{}}{}} output: 1
 * */

public class MinimumCostToMakeStringValid {
	
	/*Method-1 without extra space*/
	 public  int findMinimumCost(String str) {
			if((str.length()&1)!=0)
				return -1;
			int ans=0, bal=0,close=0;
			for(int i=0;i<str.length();i++) {
				bal+=str.charAt(i)=='{'?1:-1;
				if(bal==-1){
					ans++;
					bal++;
					close++;
				}
			}
			if(ans==0)
				return bal/2;
			else{
				return (close+1)/2+(bal+1)/2;
			}
			
	    }
	 /*Method 2 without extra space*/
	 public static int findMinimumCost2(String str) {
			if((str.length()&1)!=0)
				return -1;
			int addCount=0, currCount=0;
			for(char c:str.toCharArray()){
				if(c=='{')
					currCount++;
				else{
					if(currCount>0)
						currCount--;
					else
						addCount++;
				}
			}
			return (addCount+1)/2+(currCount+1)/2;
	    }
	 /*Method 3*/
	 

}
