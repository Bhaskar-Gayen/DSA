package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CycleDetectionInUndirectedGraph {
	
	 public  String cycleDetection(int[][] edges, int n, int m) {
	        //create adjacency list of the graph
	        Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
	        for (int e = 0; e <m ; e++) {
	            int u = edges[e][0];
	            int v = edges[e][1];
	            if (adjacencyList.get(u) == null) {
	                ArrayList<Integer> temp = new ArrayList<>();
	                temp.add(v);
	                adjacencyList.put(u, temp);
	            } else {
	                ArrayList<Integer> temp = adjacencyList.get(u);
	                temp.add(v);
	                adjacencyList.put(u, temp);
	            }

	            if (adjacencyList.get(v) == null) {
	                ArrayList<Integer> temp = new ArrayList<>();
	                temp.add(u);
	                adjacencyList.put(v, temp);
	            } else {
	                ArrayList<Integer> temp = adjacencyList.get(v);
	                temp.add(u);
	                adjacencyList.put(v, temp);
	            }
	        }
	        
	        boolean[] visited=new boolean[n+1];
	        Map<Integer, Integer> parent=new HashMap<>();
	        //Queue requir for BFS Traversal
	        Queue<Integer> queue=new LinkedList<>();
	        //function call for all component
	        for(int v=1;v<=n;v++)
	            if(!visited[v]&&hasCycleDFS(adjacencyList,visited,parent,v))
	                return "Yes";

	      return "No";
	    }
	    
	     boolean hasCycleDFS(Map<Integer, ArrayList<Integer>> adjacencyList, boolean[] visited, 
	                            Map<Integer, Integer> parent,  int src){
	        visited[src]=true;
	        if(adjacencyList.get(src)!=null){
	            for(int adjVertex: adjacencyList.get(src)){
	                if(visited[adjVertex]&&parent.get(src)!=null&&parent.get(src)!=adjVertex)
	                    return true;
	                else
	                     if(!visited[adjVertex]){
	                        parent.put(adjVertex,src);
	                        return hasCycleDFS(adjacencyList, visited, parent,adjVertex);
	                    }
	            }
	        }
	        return false;
	    }
	    
	     boolean hasCycleBFS( Map<Integer, ArrayList<Integer>> adjacencyList, boolean[] visited, 
	                            Map<Integer, Integer> parent, Queue<Integer> queue, int src){
	        queue.add(src);
	        while(!queue.isEmpty()){
	            int vertex=queue.poll();
	            visited[vertex]=true;
	            //check for isolated vertex
	            if(adjacencyList.get(vertex)!=null){
	                for(int adjVertex: adjacencyList.get(vertex)){
	                if(visited[adjVertex]&&parent.get(vertex)!=adjVertex)
	                    return true;
	                else
	                     if(!visited[adjVertex]){
	                        queue.add(adjVertex);
	                        parent.put(adjVertex,vertex);
	                    }
	            }
	          }
	        }
	        return false;
	    }

}
