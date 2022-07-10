package graph;

/**
 * Coding Ninja: Topological Sort
 * Difficulty: MEDIUM
 * Topological Sort ( Using Kahn's Algorithm ) 
 * A Directed Acyclic Graph (DAG) is a directed graph that contains no cycles.
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortKahasAlgorithm {
	
	 public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int V, int e) 
	    {
	        //step-1: cretae adjacency list and find indegree of all nodes
	        Map<Integer, ArrayList<Integer>> adjacencyList=new HashMap<>();
	        int[] indegree=new int[V];
	        for(ArrayList<Integer> edge: edges){
	            int u=edge.get(0);
	            int v=edge.get(1);
	            indegree[v]++;
	            ArrayList<Integer> temp=adjacencyList.get(u);
	            if(temp==null){
	                temp=new ArrayList<>();
	                temp.add(v);
	            }else
	                temp.add(v);
	            adjacencyList.put(u, temp);
	        }
	        //step-2: insert 0 indegree node to queue
	        Queue<Integer> queue=new LinkedList<>();
	        boolean[] visited=new boolean[V];
	        ArrayList<Integer> ans=new ArrayList<>();
	        for(int i=0;i<indegree.length;i++)
	            if(indegree[i]==0)
	                queue.add(i);
	        BFS(adjacencyList, queue, indegree, visited, ans);
	        return ans;
	    }
	     void BFS(Map<Integer, ArrayList<Integer>> adjacencyList, Queue<Integer> queue, 
	                    int[] indegree, boolean[] visited, ArrayList<Integer> ans){
	        while(!queue.isEmpty()){
	            int vertex=queue.poll();
	            if(!visited[vertex]){
	                visited[vertex]=true;
	                ans.add(vertex);
	                //adjacent vertex of the visited node
	                ArrayList<Integer> temp=adjacencyList.get(vertex);
	                if(temp!=null){
	                    for(int v:temp){
	                        indegree[v]--;
	                        if(indegree[v]==0)
	                            queue.add(v);
	                    }
	                }
	            }
	        }
	    }

}
