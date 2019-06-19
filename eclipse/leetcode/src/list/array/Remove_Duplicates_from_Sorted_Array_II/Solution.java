package list.array.Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int current=nums[0],times=0,next=0;
        int counter = nums.length;
        for(int i=0;i<nums.length;i++) {
        	if(i>=nums.length-next)break;
        	if(nums[i]==current)times++;
        	else {
        		current = nums[i];
        		if(times>2) {
        			for(int j = i;j<nums.length-next;j++)
        				nums[j-(times-2)]=nums[j];
        			i=i-(times-2);
        			next = nums.length-counter;
        		}
        		times=1;
        	}
        	if(times>2) {
        		counter--;
        	}
        }
    	return counter;
    }
    
    public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		new Solution().removeDuplicates(nums);
	}
    
    
}
