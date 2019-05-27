package tree.construct_binary_search_tree_from_preorder_traversal;

import tree.TreeNode;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
    	return construct(preorder, 0, preorder.length);
    }
    public TreeNode construct(int[] preorder,int l,int r) {
    	if(l>=r)return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = l+1;
        while(i<r&&preorder[i]<root.val) {
        	i++;
        }
        if(i>l)
        	root.left = construct(preorder,l+1,i);
        
        if(i<r)
        	root.right = construct(preorder, i, r);
        return root;
    }
    public static void main(String[] args) {
		int[] p = {8,5,1,7,10,12};
		new Solution().bstFromPreorder(p);
	}
}
