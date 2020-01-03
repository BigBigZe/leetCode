package sort.first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==Integer.MAX_VALUE-10)continue;
        	else if(nums[i]<=0||nums[i]>nums.length) {
            	nums[i] = 0;
            }else {
            	if(nums[i]==i+1) {
            		nums[i] = Integer.MAX_VALUE-10;
            		continue;
            	}
            	int k = nums[i];
            	nums[i] = 0;
            	visited(k,nums);
            }
            
        }
        for(int i=0;i<nums.length;i++)
        	if(nums[i]==0)return i+1;
        return nums.length+1;
    }

	private void visited(int i, int[] nums) {
		// TODO Auto-generated method stub
		if(i<=0||i>nums.length)return;
		int next = nums[i-1];
		nums[i-1] = Integer.MAX_VALUE-10;
		visited(next, nums);
	}
	public static void main(String[] args) {
		int[] nums = {3,2,1};
		System.out.println(new Solution().firstMissingPositive(nums));
	}
}
