package search.find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {
        //没有旋转的时候
    	if(nums.length==1||nums[0]<nums[nums.length-1])return nums[0];
    	
    	int res = 0;
    	int l = 0,r = nums.length-1;
    	while(l<r) {
    		res = (l+r)/2;
    		if(nums[res]>nums[l]&&nums[res]>nums[r])
    			l = res+1;
    		else
    			r = res;
    	}
    	return nums[l];
    }
}
