package list.array.array_nesting;

import java.util.HashSet;
import java.util.Set;

public class Solution {
/**
 * 第一版 蜗牛版
 * */
	
//    public int arrayNesting(int[] nums) {
//    	int max = 0;
//    	Set<Integer> s = new HashSet<>();
//    	Set<Integer> all = new HashSet<>();
//        for(int key:nums) {
//        	if(all.contains(key))continue;
//        	else s.clear();
//        	int element = key;
//        	while(s.add(element)) {
//        		all.add(element);
//        		element = nums[element];
//        	}
//        	max = max>s.size()?max:s.size();
//        	if(max>nums.length/2)return max;
//        }
//        return max;
//    }
	
/**
 * 第二版 龟速版
 */
//    public int arrayNesting(int[] nums) {
//    	int max = 0;
//    	int[] flag = new int[nums.length];
//    	Set<Integer> s = new HashSet<>();
//        for(int key:nums) {
//        	if(flag[key]==1)continue;
//        	else s.clear();
//        	int element = key;
//        	while(s.add(element)) {
//        		flag[element]=1;
//        		element = nums[element];
//        	}
//        	max = max>s.size()?max:s.size();
//        	if(max>nums.length/2)return max;
//        }
//        return max;
//    }
	
/**
 * 第三版：火箭版
 */
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int each : nums) {
            int count = 0;
            while (!visited[each]) {
                visited[each] = true;
                each = nums[each];
                count++;
            }
            res = Math.max(res, count);
            if (res > n / 2) return res;
        }
        return res;
    }
}
