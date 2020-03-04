package bfs.rotting_oranges;

public class Solution {
	int res=0;
    public int orangesRotting(int[][] grid) {
        infect(grid,2);
        for(int i=0;i<grid.length;i++)
        	for(int j=0;j<grid[0].length;j++)
        		if(grid[i][j]==1)return -1;
        return res;
    }
	private void infect(int[][] grid, int level) {
		// TODO Auto-generated method stub
		boolean next = false;
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				if(grid[i][j]==level) {
					next = true;
					infected(grid,i,j,level);
				}
		if(next)infect(grid,level+1);
		else res = level-3>0?level-3:0;
	}
	private void infected(int[][] grid, int i, int j, int level) {
		// TODO Auto-generated method stub
		if(i-1>=0&&grid[i-1][j]==1)grid[i-1][j]=level+1;
		if(i+1<grid.length&&grid[i+1][j]==1)grid[i+1][j]=level+1;
		if(j-1>=0&&grid[i][j-1]==1)grid[i][j-1]=level+1;
		if(j+1<grid[0].length&&grid[i][j+1]==1)grid[i][j+1]=level+1;
	}

}
