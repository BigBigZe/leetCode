package dp.house_robber_ii;

public class Solution {
    public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int pre=0,prepre=0;
		for(int i=1;i<nums.length;i++) {
			int cur = Math.max(pre, prepre+nums[i]);
			prepre = pre;
			pre = cur;
		}
		int values1 = pre;
		pre=0;prepre=0;
		for(int i=0;i<nums.length-1;i++) {
			int cur = Math.max(pre, prepre+nums[i]);
			prepre = pre;
			pre = cur;
		}
		return values1>pre?values1:pre;
    }
    
    public static void main(String[] args) {
		int[] nums = {2,3,2};
		new Solution().rob(nums );
	}
}
