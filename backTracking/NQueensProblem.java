package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NQueensProblem {
	
	static Map<Integer,Boolean> rowMap=new HashMap<>();
    static Map<Integer,Boolean> lowerDigonal=new HashMap<>();
    static Map<Integer,Boolean> upperDigonal=new HashMap<>();
	
	public static ArrayList<ArrayList<Integer>> nQueens(int n)
    {
        int[][] board=new int[n][n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        findPosition(board, ans, 0,n);
        return ans;
    } 
    static void findPosition(int[][] board, ArrayList<ArrayList<Integer>>ans, int col, int n){
        //base case
        if(col==n){
            addSolution(board,ans,n);
            return;
        }
        //Solve 1 case rest of Recursion solve
        for(int row=0;row<n;row++){
            if(isSafe(row,col,n)){
                board[row][col]=1;
                rowMap.put(row,true);
                lowerDigonal.put(row+col,true);
                upperDigonal.put(n-1+col-row,true);
                //function cll
                findPosition(board,ans,col+1,n);
                //backtracking
                board[row][col]=0;
                rowMap.put(row,false);
                lowerDigonal.put(row+col,false);
                upperDigonal.put(n-1+col-row,false);
            }  
        }
        
    }
    
    static boolean isSafe(int row, int col, int n){
        //Queen check in row
        if(rowMap.get(row)!=null&&rowMap.get(row))
            return false;
        //Queen check Lower Digonal
        if(lowerDigonal.get(row+col)!=null&&lowerDigonal.get(row+col))
            return false;
        //Queen check for Upper Digonal
        if(upperDigonal.get(n-1+col-row)!=null&&upperDigonal.get(n-1+col-row))
            return false;
        return true;
    }
    
    static void addSolution(int[][] board, ArrayList<ArrayList<Integer>>ans, int n){
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                temp.add(board[i][j]);
        ans.add(temp);
    }

}
