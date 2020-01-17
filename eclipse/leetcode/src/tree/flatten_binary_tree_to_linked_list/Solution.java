package tree.flatten_binary_tree_to_linked_list;

import tree.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
    	if(root==null)return;
    	flatten(root.left);
    	flatten(root.right);
    	if(root.left==null)return;
    	TreeNode tmp = root.left;
    	while(tmp.right!=null)
    		tmp = tmp.right;
    	tmp.right = root.right;
    	root.right = root.left;
    	root.left = null;
    }

	private TreeNode flat(TreeNode root) {
		// TODO Auto-generated method stub
		
		if(root==null)return null;
		
		if(root.left!=null)root.left = flat(root.left);
		if(root.right!=null)root.right = flat(root.right);
		
		
		
		
		return root;
	}
	
}
