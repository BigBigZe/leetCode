package moving_window.sliding_window_maximum;

import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<=1)return nums;
    	LinkedList<Integer> queue = new LinkedList<>();
    	for(int i=0;i<nums.length&&i<k;i++) {
    		if(queue.isEmpty())queue.addLast(nums[i]);
    		else if(queue.getLast()>=nums[i])queue.addLast(nums[i]);
    		else {
    			int counter = 0;
    			while(!queue.isEmpty()&&queue.getLast()<nums[i]) {
    				queue.removeLast();counter++;
    			}
    			for(;counter>=0;counter--)
    				queue.addLast(nums[i]);
    		}
    	}
    	int[] res = new int[1];
    	
    	if(k>=nums.length) {
    		res[0] = queue.getFirst();
    		return res;
    	}
    	res= new int[nums.length+1-k];
    	for(int i=0;i<res.length;i++) {
    		res[i]=queue.removeFirst();
            if(i+k>=nums.length)break;
    		if(queue.isEmpty()||nums[i+k]<=queue.getLast())queue.addLast(nums[i+k]);
    		else {
    			int counter = 0;
    			while(!queue.isEmpty()&&queue.getLast()<nums[i+k]) {
    				queue.removeLast();counter++;
    			}
    			for(;counter>=0;counter--)
    				queue.addLast(nums[i+k]);
    		}
    	}
    	return res;
    }
}