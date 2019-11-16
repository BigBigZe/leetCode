package graph.mst;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import graph.Edge;

public class Kruskal {
	
	public List<Edge> mst(List<Edge> edges,int n){
		int[] visited = new int[n];
		PriorityQueue<Edge> queue = new PriorityQueue<>(edges);
		List<Edge> res = new LinkedList<Edge>();
		while(res.size()<n-1) {
			Edge e = queue.poll();
			if(visited[e.start]==1&&visited[e.end]==1)
				continue;
			
			visited[e.start]=1;
			visited[e.end]=1;
			res.add(e);
			
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] m = {{0,7,9,11,999,999},
				{7,0,8,999,999,20},
				{9,8,0,999,6,999},
				{11,999,999,0,3,999},
				{999,999,6,3,0,1},
				{999,20,999,999,1,0}};
	}
}
