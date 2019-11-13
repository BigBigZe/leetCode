package graph.shortest_paths.no_weight;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import graph.Vertex;

public class NoWeightShortestPath {
	void unWeighted(List<Vertex> list, int source) {
		Vertex s = list.get(source);
		s.dist = 0;
		for(Vertex v:list)
			v.dist = -1;
		Queue<Vertex> queue = new LinkedBlockingQueue<>();
		while(!queue.isEmpty()) {
			Vertex v = queue.poll();
			for(Vertex next: v.list) {
				if(next.dist==-1) {
					next.dist=v.dist+1;
					next.last = v;
					queue.add(next);
				}
			}
		}
	}
}
