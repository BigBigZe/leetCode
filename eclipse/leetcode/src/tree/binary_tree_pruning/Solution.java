package tree.binary_tree_pruning;

import tree.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
    	check(root);
    	return root;
    }
    public boolean check(TreeNode root) {
    	if(root==null)return true;   	
    	root.left = check(root.left)? null:root.left;
    	root.right = check(root.right)? null:root.right;
    	if(root.val==0&&root.right==null&&root.left==null)return true;
    	else return false;
    }
}
