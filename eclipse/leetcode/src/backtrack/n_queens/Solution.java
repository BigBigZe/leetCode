package backtrack.n_queens;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<String>> res = new LinkedList<List<String>>();
	List<String> list = new LinkedList<>();
	int[] visited;
	String tmp="";
    public List<List<String>> solveNQueens(int n) {
    	visited = new int[n];
    	for(int i=0;i<n;i++)
    		tmp+='.';
    	dfs(0,n);
    	return res;   
    }
	private void dfs(int level, int n) {
		// TODO Auto-generated method stub
		if(level==n) {
			res.add(new LinkedList<>(list));
			return;
		}
		StringBuilder sb = new StringBuilder(tmp);
		for(int j=0;j<n;j++) {
			if(isValid(level,j)) {
				sb.setCharAt(j, 'Q');
				list.add(new String(sb));
				visited[level]=j;
				dfs(level+1, n);
				visited[level]=0;
				sb.setCharAt(j, '.');
				list.remove(list.size()-1);
			}
		}
	}
	private boolean isValid(int level, int j) {
		// TODO Auto-generated method stub
		for(int i=level-1;i>=0;i--)
			if(j==visited[i]||(j+level)==(i+visited[i])
			||(j-level)==(visited[i])-i)return false;
		return true;
	}
	public static void main(String[] args) {
		new Solution().solveNQueens(2);
	}
}
