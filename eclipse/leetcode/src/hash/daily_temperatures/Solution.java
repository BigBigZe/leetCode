package hash.daily_temperatures;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int[] dailyTemperatures(int[] T) {
    	int[] output = new int[T.length];
    	output[output.length-1]=0;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	map.put(T[T.length-1], T.length-1);
    	for(int i=T.length-2;i>=0;i--) {
    		int temperature = T[i];
			int recent = Integer.MAX_VALUE;
			for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
				if(entry.getKey()>temperature)
					recent = Math.min(recent, entry.getValue());
			}
			output[i] = recent==Integer.MAX_VALUE?0:recent-i;
			map.put(temperature, i);
		
    	}
        return output;
    }
    public static void main(String[] args) {
		int[] T = {55,38,53,81,61,93,97,32,43,78};
		int []  res = new Solution().dailyTemperatures(T);
		for (int i : res) {
			System.out.print(i+" ");
		}
	}
}
