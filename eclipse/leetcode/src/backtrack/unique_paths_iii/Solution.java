package backtrack.unique_paths_iii;
/**
 * 980. 不同路径 III
 * @author zone
 *
 */
public class Solution {
	int res = 0;
	int[][] visited ;
	int n = 1;
    public int uniquePathsIII(int[][] grid) {
    	int start = 0,end = 0;
        visited = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++)
        	for(int j=0;j<grid[0].length;j++)
        		if(grid[i][j]==0)n++;
        		else if(grid[i][j]==1) {
        			start = i;
        			end = j;
        		}
        dfs(grid,0,start,end);
        return res;
    }
	private void dfs(int[][] grid,int counter,int i,int j) {
		// TODO Auto-generated method stub
		if(i>=grid.length||i<0||j>=grid[0].length
				||j<0||visited[i][j]==1||grid[i][j]==-1
				||(grid[i][j]==2&&counter<n))return;
		if(counter==n&&grid[i][j]==2) {
			res++;
			return;
		}
		
		visited[i][j]=1;
		
		dfs(grid, counter+1, i-1, j);
		dfs(grid, counter+1, i+1, j);
		dfs(grid, counter+1, i, j-1);
		dfs(grid, counter+1, i, j+1);
		
		visited[i][j] = 0;
	}
}
