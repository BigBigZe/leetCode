package dp.decode_ways;

import java.util.List;

public class Solution {
    public int numDecodings(String s) {
    	int n = s.length();
    	int [] dp = new int[n+1];
    	dp[0] = 1;dp[1]=s.charAt(0) == '0' ? 0 : 1;
    	for(int i=2;i<n+1;i++) {
    		int num = Integer.parseInt(s.substring(i-2,i));
    		if(num<=26&&num>=10)
    			dp[i] += dp[i-2];
    		if(s.charAt(i-1)!='0')
    			dp[i] += dp[i-1];
    	}
    	return dp[n];
    }
    

    
    public static void main(String[] args) {
    	
		new Solution().numDecodings("226");
    	
	}
}
