package dp.knapsack;

public class Solution {
	public int knapsack(int[] weights,int[] values, int target) {
		int n = weights.length;
		int[][] dp = new int[n+1][target+1];

		for(int i=1;i<=n;i++)
			for(int j=1;j<=target;j++) {
				if(weights[i-1]<=j) {
					dp[i][j] = Math.max(dp[i-1][j],
							dp[i-1][j-weights[i-1]]+values[i-1] );
				}else
					dp[i][j] = dp[i-1][j];
			}
		System.out.println(dp[n][target]);
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<target+1;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		int c = target;
		int[] res = new int[n];
		for(int i=n;i>0;i--) {
			if(dp[i][c]>dp[i-1][c]) {
				c-=weights[i-1];
				res[i-1]=1;
			}
		}
		for(int i:res)
			System.out.print(i+" ");
		return dp[n][target];
	}
	
	
	public static void main(String[] args) {
		int target = 12;
		int[] weights = {0, 1, 3, 2, 6, 2};
		int[] values = {2, 2, 5, 3, 10, 4};
		new Solution().knapsack(weights , values, target );
	}
}
