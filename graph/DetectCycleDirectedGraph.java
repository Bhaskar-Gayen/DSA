package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DetectCycleDirectedGraph {

	public boolean detectCycleInDirectedGraph(int V, ArrayList<ArrayList<Integer>> edges) {
		// create adjacency list
		Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
		 int[] indegree=new int[V+1];
		for (ArrayList<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			indegree[v]++;
			ArrayList<Integer> temp = adjacencyList.get(u);
			if (temp == null) {
				temp = new ArrayList<>();
				temp.add(v);
			} else
				temp.add(v);
			adjacencyList.put(u, temp);
		}

		// DFS function call
		boolean[] visited = new boolean[V + 1];
		boolean[] dfscall = new boolean[V + 1];
		for (int vertex = 1; vertex <= V; vertex++)
			if (!visited[vertex] && hasCycleDFS(adjacencyList, visited, dfscall, vertex))
				return true;
		return false;
	}

	boolean hasCycleDFS(Map<Integer, ArrayList<Integer>> adjacencyList, boolean[] visited, boolean[] dfscall, int src) {
		visited[src] = true;
		dfscall[src] = true;

		if (adjacencyList.get(src) != null) {
			for (int adjVertex : adjacencyList.get(src)) {
				if (!visited[adjVertex] && hasCycleDFS(adjacencyList, visited, dfscall, adjVertex))
					return true;
				else if (visited[adjVertex] && dfscall[adjVertex])
					return true;

			}
		}
		return dfscall[src] = false;
	}
	
	
	/*Cycle Detection using BFS by applying Khans Algorithm*/
	 boolean BFS(Map<Integer, ArrayList<Integer>> adjacencyList,int[] indegree, int V) {
		 Queue<Integer> queue=new LinkedList<>();
	        boolean[] visited=new boolean[V+1];
	      //insert 0 indegree node to queue
	        for(int i=1;i<=V;i++)
	            if(indegree[i]==0)
	                queue.add(i);
		int count = 0;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			if (!visited[vertex]) {
				visited[vertex] = true;
				count++;
				// adjacent vertex of the visited node
				ArrayList<Integer> temp = adjacencyList.get(vertex);
				if (temp != null) {
					for (int v : temp) {
						indegree[v]--;
						if (indegree[v] == 0)
							queue.add(v);
					}
				}
			}
		}
		return count < V;
	}

}
