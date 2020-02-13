package dp.matrix_multiplication;

public class Solution {
	public int multiple(int[] nums) {
		int n = nums.length-1;
		int[][] dp = new int[n][n];
		for(int len=1;len<n;len++) {
			for(int i=0;i<n-len;i++) {
				int j = i+len;
				dp[i][j] = 99999999;
				for(int k=i;k<j;k++) {
					dp[i][j] = Math.min(dp[i][j], nums[i]*nums[k]*nums[j+1]);
				}
			}
		}
		System.out.println(dp[0][n-1]);
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		int[] nums = {30,35,15,5,10,20,25};
		new Solution().multiple(nums);
	}
}
