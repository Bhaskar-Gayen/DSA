package recursion;

import java.util.ArrayList;
import java.util.Collections;

/**GeeksforGeeks: Rat in a Maze Problem - I 
 * Input:
N = 4
m[][] = {{1, 0, 0, 0},
     {1, 1, 0, 1}, 
     {1, 1, 0, 0},
     {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR*/

public class RatInMaze {
	
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

}
