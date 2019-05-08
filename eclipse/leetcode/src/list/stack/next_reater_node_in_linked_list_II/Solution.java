package list.stack.next_reater_node_in_linked_list_II;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<res.length;i++) {
        	while(!s.isEmpty()&&nums[i]>nums[s.peek()]) {
        		res[s.pop()] = nums[i];
        	}
        	s.push(i);
        }
        if(!s.isEmpty())
        for(int i=0;i<s.lastElement();i++) {
        	while(!s.isEmpty()&&nums[i]>nums[s.peek()]) {
        		res[s.pop()] = nums[i];
        	}
        }
        while(!s.isEmpty())res[s.pop()] = -1;
        return res;
    }
}
