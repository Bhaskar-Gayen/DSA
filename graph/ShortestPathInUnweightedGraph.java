package graph;

/**
 * Coding NIinja: Shortest path in an unweighted graph
 * Difficulty: MEDIUM
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathInUnweightedGraph {
	
	public  LinkedList<Integer> shortestPath(int[][] edges, int V, int m, int s, int t) {
		Map<Integer,ArrayList<Integer>> adjacencyList=new HashMap<>();
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            ArrayList<Integer> temp=adjacencyList.get(u);
            if(temp==null){
                temp=new ArrayList<>();
                temp.add(v);
            }
            else
                temp.add(v);
            
            adjacencyList.put(u,temp);
            temp=adjacencyList.get(v);
            if(temp==null){
                temp=new ArrayList<>();
                temp.add(u);
            }
            else
                temp.add(u);
            
            adjacencyList.put(v,temp);
        }
         
        boolean[] visited=new boolean[V+1];
       
        return BFS(adjacencyList, visited, s,t);
	}
    
     LinkedList<Integer> BFS(Map<Integer,ArrayList<Integer>> adjacencyList, boolean[] visited, 
                                  int src, int terget){
        Queue<Integer> queue=new LinkedList<>();
        Map<Integer,Integer> parent=new HashMap<>();
        queue.add(src);
        parent.put(src,null);
        visited[src]=true;
        while(!queue.isEmpty()){
            int front=queue.poll();
            if(adjacencyList.get(front)!=null)
            for(int adj: adjacencyList.get(front)){
                if(!visited[adj]){
                    visited[adj]=true;
                    parent.put(adj,front);
                    queue.add(adj);
                }
            }
        }
        //trace the path from parent Mapping
        LinkedList<Integer> ans=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        stack.add(terget);
        while(parent.get(terget)!=null){
            stack.add(parent.get(terget));
            terget=parent.get(terget);
        }
        //reverse the path
		while (!stack.isEmpty())
			ans.add(stack.pop());
         
        return ans;
    }

}
