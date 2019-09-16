package search.search_in_rotated_sorted_array;

public class Solution {
	public int search(int[] nums, int target) {
		return search(nums,target,0,nums.length-1);
	}

	private int search(int[] nums, int target, int l, int h) {
		// TODO Auto-generated method stub
		if(l>h)return -1;
		int m = (l+h)/2,res = -1;
		if(nums[m]==target)return m;
		
		if(nums[m]>target) {
			res = search(nums, target,l,m-1);
			return res==-1?search(nums,target,m+1,h):res;
		}else {
			res = search(nums,target,m+1,h);
			return res==-1?search(nums,target,l,m-1):res;
		}		
	}
}
