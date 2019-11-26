package bfAnddf.number_of_islands;


public class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]=='1') {
        			connect(i,j,grid);
        			counter++;
        		}
        	}
        }
        
        return counter;
    }

	private void connect(int i, int j, char[][] grid) {
		// TODO Auto-generated method stub
		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1')return;
		grid[i][j] = '2';
		connect(i-1, j, grid);
		connect(i+1, j, grid);
		connect(i, j-1, grid);
		connect(i, j+1, grid);
	}
}
