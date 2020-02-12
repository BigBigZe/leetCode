package dp.decode_ways;

import java.util.List;

public class Solution {
    public int numDecodings(String s) {
    	int n = s.length();
    	int[][] dp = new int[n][n];
    	for(int i=0;i<n-1;i++) {
    		dp[i][i]=1;
    		int last = Integer.parseInt(s.substring(i, i+2));
    		if(last<=26)dp[i][i+1]=2;
    	}
    	dp[n-1][n-1] = 1;
    	for(int k=1;k<n;k++) {
    		for(int i=0;i+k<n;i++) {
    			int max = 0;
    			max = max>dp[i][i+k]?max:dp[i][i+k];
    			for(int j=i;j<=i+k;j++) {
    				max=max>dp[i][j]*dp[j+1][i+k]?max:dp[i][j]*dp[j+1][i+k];
    			}
    			dp[i][i+k]=max;
    		}
    	}
    	return dp[0][n-1];
    }
    
    public int a(List<Integer> list) {
    	return 1;
    }

    
    public static void main(String[] args) {
    	
//		new Solution().numDecodings("262");
    	
	}
}
