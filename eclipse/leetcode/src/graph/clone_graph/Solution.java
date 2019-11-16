package graph.clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import graph.Node;

public class Solution {
    public Node cloneGraph(Node node) {
    	Map<Integer, Node> map = new HashMap<Integer, Node>();
    	return clone(node,map);  
    }

	private Node clone(Node node, Map<Integer, Node> map) {
		// TODO Auto-generated method stub
		if(map.containsKey(node.val))return null;
		Node re = new Node();
		re.val = node.val;
		re.neighbors = new LinkedList<Node>();
		map.put(re.val, re);
		for(Node n:node.neighbors) {
			if(!map.containsKey(n.val))
				re.neighbors.add(clone(n,map));
		}
		return re;
	}
}
