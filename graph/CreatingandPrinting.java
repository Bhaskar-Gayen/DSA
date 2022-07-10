package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Coding Ninja: Creating and Printing
 * 	*/

public class CreatingandPrinting {
	
	public int[][] printAdjacency(int n, int m, int[][] edges) {
        Map<Integer,ArrayList<Integer>> adjacencyList=new HashMap<>();
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(adjacencyList.get(u)==null){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(u);
                temp.add(v);
                adjacencyList.put(u,temp);
            }
            else{
                ArrayList<Integer> temp=adjacencyList.get(u);
                temp.add(v);
                adjacencyList.put(u,temp);
            }
            
            if(adjacencyList.get(v)==null){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(v);
                temp.add(u);
                adjacencyList.put(v,temp);
            }
            else{
                ArrayList<Integer> temp=adjacencyList.get(v);
                temp.add(u);
                adjacencyList.put(v,temp);
            }
        }
        
        int[][] ans=new int[n][n];
        for(int i=0;i<n;i++){
            if(adjacencyList.get(i)!=null){
              ArrayList<Integer> temp=adjacencyList.get(i);
                int[] arr = temp.stream().mapToInt(j -> j).toArray();
                
                ans[i]=arr;
            }else{
                ans[i]=new int[]{i};
            }
        }
        return ans;
    }

}
