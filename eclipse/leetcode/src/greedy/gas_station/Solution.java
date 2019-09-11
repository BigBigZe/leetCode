package greedy.gas_station;

public class Solution {
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	for(int start=0;start<gas.length;start++) {
    		int sum = 0;
    		for(int i=start;i<(start+gas.length);i++) {
    			sum += gas[i%gas.length]-cost[i%gas.length];
    			if(sum<0)break;
    		}
    		if(sum>=0)return start;
    	}
        return -1;
    }
    
    public int dp(int[] gas, int[] cost) {
    	int res = 0;
    	int sum1 = 0,sum2=0;
    	for(int start=0;start<gas.length;start++) {
    		sum1 += gas[start] - cost[start];
    		sum2 += gas[start] - cost[start];
    		if(sum2<0) {
    			res = start+1;
    			sum2 = 0;
    		}
    	}
    	return sum1>=0? res : -1;
    }
    
    public static void main(String[] args) {
		int[] gas = {5,1,2,3,4};
		int[] cost = {4,4,1,5,1};
		new Solution().canCompleteCircuit(gas, cost);
	}
}
