package tree.path_sum_ii;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class Solution {
	List<List<Integer>> list = new ArrayList<>();
	List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        find(root,sum);
    	return list;
    }
	private void find(TreeNode root,int total) {
		// TODO Auto-generated method stub
		if(root==null)return;
		tmp.add(root.val);
		if(total-root.val==0&&root.right==null&&root.left==null)
			list.add(new ArrayList<>(tmp));
		find(root.left,total-root.val);
		find(root.right,total-root.val);
		tmp.remove(tmp.size()-1);
		
	}
}
