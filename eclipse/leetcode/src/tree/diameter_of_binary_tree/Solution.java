package tree.diameter_of_binary_tree;

import tree.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        
        int max1 = maxPath(root.left)+maxPath(root.right);
        int max2 = diameterOfBinaryTree(root.left);
        int max3 = diameterOfBinaryTree(root.right);
        
        return Math.max(Math.max(max1,max2),max3);
    }
    
    public int maxPath(TreeNode root){
        
        if(root == null)return 0;
        else return Math.max(maxPath(root.left),maxPath(root.right))+1;
    }
}
