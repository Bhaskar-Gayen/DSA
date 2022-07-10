package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DFSTraversal {

	public  ArrayList<ArrayList<Integer>> depthFirstSearch(int V, int e, ArrayList<ArrayList<Integer>> edges) {
		//Make Graph represantation in adjacemcylist
		Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
		for (int i = 0; i < e; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
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
		
		//make visited array
		boolean[] visited = new boolean[V];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			dfs(adjacencyList, visited, temp, i);
			if (temp.size() > 0)
				ans.add(temp);
		}
		return ans;
	}

	 void dfs(Map<Integer, ArrayList<Integer>> adjacencyList, boolean[] visited, ArrayList<Integer> temp,
			int vertex) {
		if (!visited[vertex]) {
			visited[vertex] = true;
			temp.add(vertex);
			//get the adjancent vertex
			ArrayList<Integer> adjacentVertex = adjacencyList.get(vertex);
			for (int i = 0; adjacentVertex != null && i < adjacentVertex.size(); i++) {
				dfs(adjacencyList, visited, temp, adjacentVertex.get(i));
			}
		}
	}

}
