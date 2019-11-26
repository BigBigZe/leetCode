package unionSet.friend_circles;

public class Solution {
    public int findCircleNum(int[][] M) {
    	int n = M.length,res=n;
    	int[] circle = new int[n];
    	for(int i=0;i<n;i++)
    		circle[i] = i;
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(M[i][j]==1&&find(i,circle)!=find(j,circle)) {
    				union(i,j,circle);
    				res--;
    			}
    				
    		}
    	}
    	return res;
    }

	private void union(int i, int j, int[] circle) {
		// TODO Auto-generated method stub
		if(find(i,circle)==find(j,circle))return;
		circle[find(i,circle)] = find(j,circle);
	}

	private int find(int j, int[] circle) {
		// TODO Auto-generated method stub
		if(j!=circle[j])
			circle[j] = find(circle[j], circle);
		
		return circle[j];
	}
}
