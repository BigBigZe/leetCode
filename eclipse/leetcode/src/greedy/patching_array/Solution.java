package greedy.patching_array;

public class Solution {
    public int minPatches(int[] nums, int n) {
    	
        long curr_range  = 0 , i=0;
        int pos = 0,res=0;
        for(;i<=n;) {
        	if(pos>=nums.length||i<nums[pos]) {
        		curr_range += i;
        		res++;
        	}else {
        		curr_range+=nums[pos];
        		pos++;
        	}
        	i = curr_range+1;
        }
        
        
        
        return res;
        
    }
}
