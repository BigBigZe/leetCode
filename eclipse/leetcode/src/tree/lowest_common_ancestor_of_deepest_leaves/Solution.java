package tree.lowest_common_ancestor_of_deepest_leaves;

import tree.TreeNode;

public class Solution {
	int min = -1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
    	return findCommon(root,0);
    }
	private TreeNode findCommon(TreeNode root,int d) {
		// TODO Auto-generated method stub
		if(root==null)return null;
		if(d == min)return root;
		if(root.left==null&&root.right==null&&d<min)return null;
		TreeNode left = findCommon(root.left, d+1);
		TreeNode right = findCommon(root.right, d+1);
		if(left!=null&&right!=null)return root;
		if(left!=null)return left;
		else return right;
	}
	private void depth(TreeNode root,int d) {
		// TODO Auto-generated method stub
		if(root==null)return;
		min = min> d?min:d;
		depth(root.left, d+1);
		depth(root.right, d+1);
	}
	
    
}
