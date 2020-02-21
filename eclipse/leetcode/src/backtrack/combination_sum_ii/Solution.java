package backtrack.combination_sum_ii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author zone
 *
 */
public class Solution {
	List<List<Integer>> res  = new LinkedList<List<Integer>>();
	List<Integer> tmp = new LinkedList<>();
	int[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new int[candidates.length];
    	Arrays.sort(candidates);
    	dfs(candidates,0,0,target);
    	return res;
    }
	private void dfs(int[] candidates, int level, int sum, int target) {
		// TODO Auto-generated method stub
		if(sum>target)return;
		if(sum==target) {
			res.add(new LinkedList<>(tmp));
			return;
		}
		
		for(int i=level;i<candidates.length;i++) {
			if(i>0&&candidates[i]==candidates[i-1]
					&&visited[i-1]!=1)continue;
			tmp.add(candidates[i]);
			dfs(candidates,i+1,sum+candidates[i],target);
			tmp.remove(tmp.size()-1);
		
		}

	}
}