package tree.construct_binary_tree_from_preorder_and_inorder_traversal;

import tree.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder,int pl,int pr,int [] inorder,
    		int il,int ir) {
    	
    	if(pl>=pr||il>=ir)return null;
    	
    	TreeNode root = new TreeNode(preorder[pl]);
    	
    	int index=0;
    	
    	for(int i=il;i<=ir;i++)
    		if(inorder[i]==root.val) {
    			index=i;
    			break;
    		}
    	int leftNum = index-il;
    	root.left = helper(preorder,pl+1,pl+leftNum,inorder,il,index-1);
    	root.right = helper(preorder,pl+leftNum+1,pr,inorder,index+1,ir);
    	
    	return root;
    }
    public static void main(String[] args) {
		int[] inorder= {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		new Solution().buildTree(preorder, inorder);
	}
}
