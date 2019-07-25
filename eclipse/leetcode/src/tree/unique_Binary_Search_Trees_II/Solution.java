package tree.unique_Binary_Search_Trees_II;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
		if(n<=0)return new LinkedList<TreeNode>();
    	return generateSubTree(1,n);
        
    }

	public List<TreeNode> generateSubTree(int start, int end) {
		// TODO Auto-generated method stub
		List<TreeNode> res = new LinkedList<>();
		if(start>end) {
			res.add(null);
			return res;
		}
		for(int i=start;i<=end;i++) {
			for (TreeNode left : generateSubTree(start, i-1)) {
				for (TreeNode right : generateSubTree(i+1, end)) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
}
