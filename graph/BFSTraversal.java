package graph;

/**
 * GFG: BFS Traversal
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BFSTraversal {
	
	 // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //make DS to run BFS
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> ans=new ArrayList<>();
        //run bfs
        bfs(adj,queue,visited,ans);
        return ans;
    }
    
    void bfs(ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue, 
            boolean[] visited, ArrayList<Integer> ans){
            while(!queue.isEmpty()){
                int vertex=queue.remove();
                if(!visited[vertex]){
                    visited[vertex]=true;
                    ans.add(vertex);
                    //Explore the vertex
                    for(int i=0;i<adj.get(vertex).size();i++){
                        queue.add(adj.get(vertex).get(i));
                    }
                    bfs(adj, queue,visited, ans);
                }
            }
    }

}
