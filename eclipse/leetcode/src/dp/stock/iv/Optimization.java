package dp.stock.iv;

public class Optimization {
	public int maxProfit(int k, int[] prices) {
		if(prices.length<=1)return 0;
		if(k>=prices.length/2) {
			int sum=0;
			for(int i=1;i<prices.length;i++)
			{
				int val = prices[i]-prices[i-1];
				sum+= val>0?val:0;
			}
			System.out.println(sum);
			return sum;
		}
		int[][][] dp = new int[k+1][prices.length+1][2];
	    for(int t = 0; t <= k; t++)
            dp[t][0][1] = -1000000;
        for(int i = 0; i < prices.length; i++)
            dp[0][i][1] = -1000000;

		for(int t=1;t<=k;t++) {
			for(int i=1;i<=prices.length;i++) {
				dp[t][i][0] = Math.max(dp[t][i-1][0], 
						dp[t][i-1][1]+prices[i-1]);
				dp[t][i][1] = Math.max(dp[t][i-1][1], 
						dp[t-1][i-1][0]-prices[i-1]);
			}
		}
		System.out.println(dp[k][prices.length][0]);
		return dp[k][prices.length][0];
	}
	public static void main(String[] args) {
		int[] prices = {3,2,6,5,0,3};
		new Optimization().maxProfit(2, prices);
	}
}
