package dp.regular_expression_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
		    	int m = s.length(),n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0]=true;
		for(int i=1;i<=n;i++) {
			if(p.charAt(i-1)=='*')dp[0][i] = dp[0][i-1]||dp[0][i-2];
		}
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')
					dp[i][j] = dp[i-1][j-1];
				else if(p.charAt(j-1)=='*') {
					if(p.charAt(j-2)=='.'||s.charAt(i-1)==p.charAt(j-2))
						dp[i][j] = dp[i][j-1]||dp[i-1][j]||dp[i][j-2];
					else
						dp[i][j]|=dp[i][j-2];
				}
			}
		
		return dp[m][n];
    }
    public static void main(String[] args) {
		String a1 = "aa",a2="bb";
		String a3 = new StringBuilder("aa").append("bb").toString();
		String a4 = a1+a2;
		System.out.println(a4.intern()==a3);
		
	}
}
