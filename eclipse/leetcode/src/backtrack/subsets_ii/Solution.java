package backtrack.subsets_ii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	List<Integer> list = new LinkedList<>();
	int[] visited ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	res.add(new LinkedList<>());
    	Arrays.sort(nums);
    	visited = new int[nums.length];
    	dfs(nums,0,nums.length);
    	return res;
    }
	private void dfs(int[] nums, int level, int length) {
		// TODO Auto-generated method stub
		if(level==length)return;
		for(int i=level;i<length;i++) {
			if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==0)continue;
			list.add(nums[i]);
			visited[i] = 1;
			res.add(new LinkedList<>(list));
			dfs(nums, i+1, length);
			visited[i]=0;
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		new Solution().subsetsWithDup(nums);
	}
}
