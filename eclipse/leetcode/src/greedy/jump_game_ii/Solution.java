package greedy.jump_game_ii;

public class Solution {
    public int jump(int[] nums) {
    	int step = 0;
    	int start = 0;
    	
    	while(start<nums.length){
    		int max = 0,maxI = 0;
    		if(start==nums.length-1)return step;
    		if(start+nums[start]>=nums.length-1)return step+1;
    		for(int i=start+1;i<=start+nums[start];i++) {
    			if(nums[i]+i>max) {
    				maxI = i;
    				max = nums[i]+i;
    			}
    		}
    		start = maxI;
    		step++;
    		
    	}
    	
    	return start;
    }
    public static void main(String[] args) {
		int[] nums = {2,3,1,1};
		new Solution().jump(nums);
	}
}
