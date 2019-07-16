package search.koko_eating_bananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
    	int max = Integer.MIN_VALUE;
    	for(int pile:piles)max = max>pile?max:pile;
    	int min = 1;
    	int res = max;
    	while(min<max) {
    		res = (min+max)>>1;
    		if(canFinish(piles,H,res)) {
    			max = res;	//这里注意不是res-1，因为res-1可能错过正确结果
    		}else {
    			min = res+1;
    		}
    	}
        return min;
    }

	private boolean canFinish(int[] piles, int h, int res) {
		// TODO Auto-generated method stub
		int time = 0;
		for(int pile:piles) {
			time += (pile+res-1)/res;// (pile-1)/res + 1
			
		}
		return time<=h;
	}
	
	
}
