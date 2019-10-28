package simple.non_decreasing_array;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length<=1)return true;
        int counter = 0;
        for(int i=1;i<nums.length-1;i++){
        	if(nums[i]>=nums[i-1])continue;
        	counter++;
        	if(i-2>=0&&nums[i]>nums[i-2])
        		nums[i]=nums[i-1];
        	else
        		nums[i-1]=nums[i];
        }
        
        return counter<=1;
    }
}
