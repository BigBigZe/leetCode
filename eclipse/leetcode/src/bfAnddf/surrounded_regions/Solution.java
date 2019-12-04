package bfAnddf.surrounded_regions;

public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)return;
        for(int i = 0;i<board[0].length;i++)
        	if(board[0][i]=='O')
        		defect(board,0,i);
        for(int i = 0;i<board[0].length;i++)
        	if(board[board.length-1][i]=='O')
        		defect(board, board.length-1,i);
        for(int i = 0;i<board.length;i++)
        	if(board[i][0]=='O')
        		defect(board,i,0);
        for(int i = 0;i<board.length;i++)
        	if(board[i][board[0].length-1]=='O')
        		defect(board, i,board[0].length-1);
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++)
        		if(board[i][j]=='O')board[i][j]='X';
        		else if (board[i][j]=='1')board[i][j]='O';
    }
    void defect(char[][] board,int i,int j) {
    	if(i<0||i>=board.length||j<0||j>=board[0].length)return;
    	if(board[i][j]=='X'||board[i][j]=='1')return;
    	board[i][j] = '1';
    	defect(board, i-1, j);
    	defect(board, i+1, j);
    	defect(board, i, j-1);
    	defect(board, i, j+1);
    }
}
