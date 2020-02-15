package dp.maximum_product_subarray;

public class Optimization {
	public int maxProduct(int[] nums) {
		
		int min = 1,max=1,res = -99999999;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0) {
				int tmp = min;
				max = min;
				min = tmp;
			}
			max = Math.max(max*nums[i], nums[i]);
			min = Math.max(min*nums[i], nums[i]);
			res = Math.max(max, min);
		}
		
		return res;
		
	}
}
