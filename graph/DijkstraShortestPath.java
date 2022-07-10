package graph;

import java.util.*;

class Pair {
	int vertex;
	int distance;

	Pair(int v, int d) {
		vertex = v;
		distance = d;
	}
}

public class DijkstraShortestPath {

	public ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
		// step-1: create weighted adjacency list
		Map<Integer, ArrayList<Pair>> adjacencyList = new HashMap<>();
		for (ArrayList<Integer> edge : vec) {

			int u = edge.get(0);
			int v = edge.get(1);
			int dis = edge.get(2);
			// edge: u->v
			ArrayList<Pair> temp = adjacencyList.get(u);
			if (temp == null)
				temp = new ArrayList<>();
			temp.add(new Pair(v, dis));
			adjacencyList.put(u, temp);
			// edge: v->u
			temp = adjacencyList.get(v);
			if (temp == null)
				temp = new ArrayList<>();
			temp.add(new Pair(u, dis));
			adjacencyList.put(v, temp);
		}

		// step-2: Initialize distance array
		int[] distance = new int[vertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		// step-3: Make a priority queue
		Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		pq.add(new Pair(source, 0));
		distance[source] = 0;
		while (!pq.isEmpty()) {
			Pair front = pq.poll();
			if (adjacencyList.get(front.vertex) != null)
				for (Pair adj : adjacencyList.get(front.vertex))
					// relax the edge
					if (distance[adj.vertex] > front.distance + adj.distance) {
						pq.add(new Pair(adj.vertex, front.distance + adj.distance));
						distance[adj.vertex] = front.distance + adj.distance;
					}
		}
		// step-4: prepair solution
		ArrayList<Integer> ans = new ArrayList<>(vertices);
		for (int i : distance)
			ans.add(i);
		return ans;
	}

}
