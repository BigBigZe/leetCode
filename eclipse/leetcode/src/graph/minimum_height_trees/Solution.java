package graph.minimum_height_trees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	List<Integer> list = new ArrayList<>(n);
    	int[] degree = new int[n];	
    	List<Integer > vector = new ArrayList<>();
    	
    	int counter = n;
    	for(int[] edge:edges) {
    		degree[edge[0]]++;
    		degree[edge[1]]++;
    	}
		for(int i=0;i<n;i++) {
			if(degree[i]==1) {
				vector.add(i);
			}
		}
    	while(counter>2) {
    		int len = vector.size();
    		counter -= len;

    		for(int i=0;i<len;i++) {
        		int j = vector.remove(0);
    			for(int[] edge:edges) {
    				if(edge[0]==j&&degree[edge[1]]>1) {
    					degree[edge[1]]--;
    					if(degree[edge[1]]==1)vector.add(edge[1]);
    				}
    					
    				if(edge[1]==j&&degree[edge[0]]>1) {
    					degree[edge[0]]--;
    					if(degree[edge[0]]==1)vector.add(edge[0]);
    				}
    					
    			}
    		}

    	}
    	while(!vector.isEmpty())
    		list.add(vector.remove(0));
    	
        return list;
    }


	
	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{0,3},{4,3},{5,4}};
		new Solution().findMinHeightTrees(6, edges);
	}
}
