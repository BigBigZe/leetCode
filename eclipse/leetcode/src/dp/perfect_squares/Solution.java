package dp.perfect_squares;

public class Solution {
    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);
        int[] dp = new int[n+1];
        for(int i=1;i<=m;i++)
        	dp[i*i]=1;
        for(int i=2;i<=n;i++) {
        	int min = 9999;
        	for(int j=1;j<i;j++) {
        		min = Math.min(min, dp[j]+dp[i-j]);
        	}
        }
    	return dp[n];
    }
}
