package dp.stock.ii;

public class Solution {
    public int maxProfit(int[] prices) {
    	int[] dp = new int[prices.length];
        int max = 0;
        if(prices.length<=1)return max;
        for(int i=1;i<prices.length;i++) {
        	int tmp = Math.max(0, prices[i]-prices[0]);
        	for(int j=1;j<i;j++) {
        		tmp = Math.max(tmp,dp[j]);
        		tmp = Math.max(tmp,dp[j-1]+prices[i]-prices[j]);
        	}
        	dp[i] = Math.max(dp[i], tmp);
        }
        System.out.println(dp[prices.length-1]);
    	return dp[prices.length-1];
    }
    public static void main(String[] args) {
		int[] prices = {6,1,3,2,4,7};
		new Solution().maxProfit(prices);
	}
}
