package simple.moving_stones_until_consecutive;

import java.util.Arrays;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
    	int[] nums = {a,b,c};
    	Arrays.sort(nums);
    	int[] res = {0,0};
    	int timesA = nums[1]-nums[0]-1,timesB = nums[2]-nums[1]-1;
    	if(timesA==0&&timesB>0) {
    		res[0]=1;
    		res[1]=timesB;
    	}else if(timesA==0&&timesB==0)return res;
    	else if(timesA>0&&timesB==0) {
    		res[0]=1;
    		res[1]=timesA;
    	}else {
    		if(timesA==1||timesB==1)
    			res[0]=1;
    		else res[0]=2;
    		res[1]=timesA+timesB;
    	}
    	return res;
    }
}
