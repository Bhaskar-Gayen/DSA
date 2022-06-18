package dp;

import java.util.Arrays;

public class UniquePath {
	
	/*Solution using Dynamic Programming-T.C=O(r*c) S.C=O(r*C)*/
	 public int uniquePaths(int r, int c) {
	        int[][] dp =new int[r][c];
	        for(int[] i:dp)
	        Arrays.fill(i,-1);
	        
	        
	        return findPathDp(r,c,0,0,dp);
	    }
	    
	    
	    //Solution using DP
	    int findPathDp(int r, int c, int x, int y, int[][] dp){
	        if(x>=r||y>=c)
	            return 0;
	            // System.out.println(x+" "+y);
	        if((x==r-1)&&(y==c-1))
	            return dp[x][y]=1;
	        
	            
	        if(dp[x][y]!=-1)
	            return dp[x][y];
	        
	         return dp[x][y]= findPathDp(r,c,x+1,y,dp)+findPathDp(r,c,x,y+1,dp);
	    }
	    
	    
	    //Time complexity is Exponential O(2^n)
	    int findPath(int r, int c, int x, int y){
	        if(x>r||y>c)
	            return 0;
	        if(x==r&&c==y)
	            return 1;
	        return findPath(r,c,x+1,y)+findPath(r,c,x,y+1);
	    }

}
