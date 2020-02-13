package dp.integer_break;
/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
 * @author zone
 *
 */
public class Solution {
    public int integerBreak(int n) {
		
    	int[] dp = new int [n+1];
    	dp[1]=1;
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			dp[i] = Math.max(dp[i],dp[j]*Math.max(i-j,dp[i-j]));
    		}
    	}
    	
    	return dp[n];
        
    }
}
