package simple.surface_area_of_3d_shapes;

public class Solution {
    public int surfaceArea(int[][] grid) {
    	if(grid.length==1)return grid[0][0]*4+2;
        int sum = 0;
    	for(int i=0;i<grid.length;i++)
    		for(int j=0;j<grid.length;j++) {
    			if(grid[i][j]!=0)sum += 4*grid[i][j]+2;
    			if(i>0)sum -= 2*(grid[i][j]>=grid[i-1][j]?grid[i-1][j]:grid[i][j]);
    			if(j>0)sum -= 2*(grid[i][j]>=grid[i][j-1]?grid[i][j-1]:grid[i][j]);
    		}
    	return sum;
    }
    public static void main(String[] args) {
		int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
		new Solution().surfaceArea(grid);
	}
}
