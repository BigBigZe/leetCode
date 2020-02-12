package dp.coin_change;

public class Solutioin {
	public int change(int[] nums,int target) {
		int n = nums.length;
		int[] dp = new int[target+1];
		for(int i=0;i<target+1;i++)dp[i]=-1;
		for(int i=1;i<=target;i++) {
			if(i<nums[0]) {
				dp[i]=-1;continue;
			}
			int min = 999999;
			for(int j=0;j<n;j++) {
				if(nums[j]==i) {min=0;break;}
				if(nums[j]<i&&dp[i-nums[j]]!=-1)
					min = Math.min(min, dp[i-nums[j]]);
			}
			min ++;
			dp[i] = min>99999?-1:min ;
		}
		System.out.println(dp[target]);
		return dp[target];
	}
	public static void main(String[] args) {
		int target = 33;
		int[] nums = {3, 4, 7};
		new Solutioin().change(nums , target);
	}
}
