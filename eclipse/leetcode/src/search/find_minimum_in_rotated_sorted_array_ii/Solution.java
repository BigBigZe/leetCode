package search.find_minimum_in_rotated_sorted_array_ii;

public class Solution {
    public int findMin(int[] nums) {
		return find(nums,0,nums.length-1);      
    }

	private int find(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if(low>=high)return nums[low];
		for(;low<high&&low+1<nums.length&&nums[low]==nums[low+1];low++);
		for(;high>low&&high-1>=0&&nums[high]==nums[high-1];high--);
		if(nums[low]==nums[high]&&low<high)high--;
		
		if(nums[low]<=nums[high])return nums[low];
		int mid = (low+high)/2;
		
		if(nums[mid]<nums[low])
			return find(nums, low+1, mid);
		else 
			return find(nums, mid+1, high);
	}
	
	public static void main(String[] args) {
		int[] nums = {3,1,3};
		System.out.println(new Solution().findMin(nums));
	}
}
