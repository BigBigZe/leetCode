package backtrack.generate_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<String> res =new LinkedList<String>();
    public List<String> generateParenthesis(int n) {
    	StringBuilder sb  = new StringBuilder();
    	dfs(sb,0,0,n);
		return res;
        
    }
	private void dfs(StringBuilder sb, int left, int right, int n) {
		// TODO Auto-generated method stub
		if(right>left||left>n||right>n)return;
		if(sb.length()==2*n)res.add(new String(sb));
		sb.append('(');
		dfs(sb,left+1,right,n);
		sb.deleteCharAt(sb.length()-1);
		sb.append(')');
		dfs(sb,left,right+1,n);
		sb.deleteCharAt(sb.length()-1);
		
		
	}

}
