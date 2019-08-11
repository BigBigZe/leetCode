package search.capacity_to_ship_packages_within_d_days;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
    	
    	int low = 0,high=0;
    	for(int weight:weights) {
    		low = Math.max(low, weight);
    		high+=weight;
    	}
    		
    	
 
    	while(low<=high) {
    		int weightInD = 1;
    		int capacity = (low+high)/2;
    		for(int weight:weights) {
    			capacity-=weight;
    			if(capacity<0) {
    				weightInD++;
    				capacity = (low+high)/2-weight;
    			}
    		}
    		if(weightInD>D)
    			low = (low+high)/2+1;
    		else
    			high = (low+high)/2-1;
    		
    		
    	}
    	
    	return low;
    	
    }
    public static void main(String[] args) {
		int[] weights = {1,2,3,1,1};
		System.out.println(new Solution().shipWithinDays(weights, 4));;
	}
}
