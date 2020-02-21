package backtrack.combination_sum;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	List<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0,0,target);
    	return res;
    }
	private void dfs(int[] candidates, int level,int sum, int target) {
		// TODO Auto-generated method stub
		if(sum>target)return;
		if(sum==target) {
			res.add(new LinkedList<>(tmp));
			return;
		}
		for(int i=level;i<candidates.length;i++) {
			tmp.add(candidates[i]);
			dfs(candidates,i,sum+candidates[i],target);
			tmp.remove(tmp.size()-1);
		}
		
	}
}
