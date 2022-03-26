package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
	
	/*GeeksforGeeks: Rat in a Maze Problem - I 
	 * Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR*/
	public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0]==0)
            return ans;
        //Starting address
        int srcx=0;
        int srcy=0;
        int[][] visited = new int[n][n];
        visited[srcx][srcy]=1;
        StringBuilder path = new StringBuilder();
        solver(m,n,srcx,srcy,visited,path,ans);
        Collections.sort(ans);
        return ans;
    }
    
    static void solver(int[][] m, int n, int x, int y, int[][] visited, StringBuilder path, ArrayList<String> ans){
        if((x==n-1)&&(y==n-1)){
            ans.add(path.toString());
            return;
        }
        visited[x][y]=1;
        //Down
        if(isSafe(x+1,y,m,n,visited)){
            path.append('D');
            solver(m,n,x+1,y,visited,path,ans);
            path.deleteCharAt(path.length()-1);
        }
        
         //Up
        if(isSafe(x-1,y,m,n,visited)){
            path.append('U');
            solver(m,n,x-1,y,visited,path,ans);
            path.deleteCharAt(path.length()-1);
        }
        
         //Left
        if(isSafe(x,y-1,m,n,visited)){
            path.append('L');
            solver(m,n,x,y-1,visited,path,ans);
            path.deleteCharAt(path.length()-1);
        }
        
         //Right
        if(isSafe(x,y+1,m,n,visited)){
            path.append('R');
            solver(m,n,x,y+1,visited,path,ans);
            path.deleteCharAt(path.length()-1);
        }
        
        visited[x][y]=0;
    }
    
    static boolean isSafe(int x, int y, int[][] m, int n, int[][] visited){
        if((x>=0&&x<n)&&(y>=0&&y<n)&&(m[x][y]==1)&&(visited[x][y]==0))
        return true;
        else
        return false;
    }
	
	
	
	
	/*LeetCode: 46. Permutations
	 * Input: nums = [1,2,3]
		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		*/
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int index=0;
        solver(nums,ans,index);
        
        return ans;
    }
    
    static void solver(int[] arr, List<List<Integer>> ans, int index){
        //base case
        if(index>=arr.length){
            List<Integer> t = new ArrayList<>();
            for(int i: arr)
                t.add(i);
            ans.add(t);
            return;
        }
        
        //process
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            solver(arr,ans,index+1);
            //Backtrack
            swap(arr,i,index);
        }
    }
    
    static void swap(int[] arr, int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
	
	
	
	/*Code Studio: Permutations of a String
	 * input: xyz
	 * output: xyz xzy yxz yzx zxy zyx */
	public static ArrayList<String> generatePermutations(String str) {
		StringBuilder input=new StringBuilder(str);
        ArrayList<String> ans = new ArrayList<>();
        int index=0;
        solver(input,ans,index);
        Collections.sort(ans);
        return ans;
	}
    static void solver(StringBuilder str, ArrayList<String> ans, int index){
        //base case
        if(index>=str.length()){
            ans.add(str.toString());
            return;
        }
        //process
        for(int i=index;i<str.length();i++){
            swap(str,i,index);
            solver(str,ans,index+1);
            //backtrack
            swap(str,i,index);
        }
        
    }
    static void swap(StringBuilder str, int index, int i){
        char c = str.charAt(index);
        str.setCharAt(index,str.charAt(i));
        str.setCharAt(i,c);
    }
	
	
	
	
	
	/*LeetCode: 17. Letter Combinations of a Phone Number 
	 * Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"] */
	
	public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int index=0;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solver(digits,ans,str,index,map);
        return ans;
    }
    static void solver(String digits, List<String> ans, StringBuilder str, int index, String[] map){
        //base case
        if(index>=digits.length()){
            ans.add(str.toString());
            return;
        }
        //process
        int d=digits.charAt(index)-'0';
        String val=map[d];
        for(int i=0;i<val.length();i++){
            StringBuilder temp=new StringBuilder(str);
            temp.append(val.charAt(i));
            solver(digits,ans,temp,index+1,map);
            temp=null;
        }
    }

}
