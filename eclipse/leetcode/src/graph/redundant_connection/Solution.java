package graph.redundant_connection;


public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    	int[] res = new int[2];
    	int[] pre = new int[edges.length+1];
    	for(int i=0;i<pre.length;i++) {
    		pre[i]=i;
    	}
    	for(int[] edge:edges) {
    		if(find(edge[0],pre)==find(edge[1],pre)) {
    			return edge;
    		}
    		union(edge[0],edge[1],pre);
    	}

    	return res;
    }

	private void union(int i, int j, int[] pre) {
		int preI = find(i,pre);
		int preJ = find(j,pre);
		if(preI==preJ)return;
		pre[find(i,pre)] = find(j,pre);
	}

	private int find(int root,int[] pre) {
		// TODO Auto-generated method stub
		if(root!=pre[root])
			pre[root] = find(pre[root],pre);
		return pre[root];
	}


}
