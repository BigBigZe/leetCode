package hash.top_k_frequent_elements;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	List<Map.Entry<Integer, Integer>> list = new LinkedList<>();
    	for(int i:nums) {
    		if(map.containsKey(i))
    			map.put(i,map.get(i)+1);
    		else
    			map.put(i, 1);
    	}
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			list.add(entry);
		}
    	list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue()>o2.getValue())return 1;
				if(o1.getValue()<o2.getValue())return -1;
				else
				return 0;
			}
		});
    	List<Integer> res = new LinkedList<>();
    	for(int i=0;i<k;i++) {
    		res.add(list.get(i).getKey());
    	}
    	return res;
    }
}
