package tree.delete_nodes_and_return_forest;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class Solution {
	List<TreeNode> list = new ArrayList<>();
	int[] dict = new int[1001];
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	for(int i:to_delete)
    		dict[i]=1;
    	delete(root);
        return list;
    }
    private TreeNode delete(TreeNode root) {
    	if(root==null)return null;
    	TreeNode right = root.right;
    	TreeNode left = root.left;
    	if(dict[root.val]==1) {
    		if(right!=null&&dict[right.val]==0)list.add(right);
    		if(left!=null&&dict[left.val]==0)list.add(left);
    	}
		root.left = delete(left);
		root.right = delete(right);
    	return dict[root.val]==1?null:root;
    	
    }
}
