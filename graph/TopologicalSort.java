package graph;

/**
 * Code Studio: Topological Sort
 * Difficulty: MEDIUM
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {
	
	 public  ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int V, int e) 
	    {
	        //create adjacency List
	       Map<Integer, ArrayList<Integer>> adjacencyList=new HashMap<>();
	        for(ArrayList<Integer> edge: edges){
	            int u=edge.get(0);
	            int v=edge.get(1);
	            ArrayList<Integer> temp=adjacencyList.get(u);
	            if(temp==null){
	                temp=new ArrayList<>();
	                temp.add(v);
	            }else
	                temp.add(v);
	            adjacencyList.put(u,temp);
	        }
//	         System.out.println(adjacencyList);
	        //DFS call on the graph
	        Stack<Integer> stack=new Stack<>();
	        boolean[] visited=new boolean[V];
	        for(int vertex=0;vertex<V;vertex++)
	            if(!visited[vertex])
	                findTopologicalSort(adjacencyList, stack, visited, vertex);
	        ArrayList<Integer> ans=new ArrayList<>();
	        while(!stack.isEmpty())
	            ans.add(stack.pop());
	        return ans;
	    }
	    void findTopologicalSort(Map<Integer, ArrayList<Integer>> adjacencyList, 
	                                    Stack<Integer> stack, boolean[] visited, int src){
	        visited[src]=true;
	        if(adjacencyList.get(src)!=null)
	            for(int adjVertex: adjacencyList.get(src))
	                if(!visited[adjVertex])
	                    findTopologicalSort(adjacencyList, stack, visited, adjVertex);
	            
	        stack.push(src);
	    }

}
