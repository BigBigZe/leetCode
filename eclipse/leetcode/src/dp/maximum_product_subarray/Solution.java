package dp.maximum_product_subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0],total = 1,begin = -1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				max = Math.max(max, 0);
				begin = i;
				total= 1;
				continue;
			}
			
			if(total>0&&nums[i]<0||total<0&&nums[i]>0) {
				int tmp = 1;
				for(int j=i;j>begin;j--) {
					tmp*=nums[j];
					max = Math.max(tmp, max);
				}
			}
			total *= nums[i];
			max = Math.max(max, total);
			
			
		}

        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
		int[] nums = {3,-1,4};
		new Solution().maxProduct(nums);
	}
}
