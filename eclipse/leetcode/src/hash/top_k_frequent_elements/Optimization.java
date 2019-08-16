package hash.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Optimization {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	List<Integer>[] bucket = new List[nums.length+1];
    	for(int i:nums) {
    		if(map.containsKey(i))
    			map.put(i,map.get(i)+1);
    		else
    			map.put(i, 1);
    	}
    	for(int key:map.keySet()) {
    		int value = map.get(key);
    		if(bucket[value]==null)
    			bucket[value]=new ArrayList<>();
    		bucket[value].add(key);
    	}
    	List<Integer> res = new ArrayList<>();
    	for(int i=nums.length;i>=1&&res.size()<k;i--) {
    		if(bucket[i]!=null)
    		res.addAll(bucket[i]);
    	}
    	return res;
    	
    }
}
