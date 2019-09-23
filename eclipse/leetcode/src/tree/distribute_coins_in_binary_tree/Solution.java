package tree.distribute_coins_in_binary_tree;

import tree.TreeNode;

public class Solution {
	int k=0;
    public int distributeCoins(TreeNode root) {
    	
        traverse(root);
        return k;
    }
	private int traverse(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)return 0;
		/*
		 * 等于1，则交给根节点0元
		 * 多于1，则把多出的钱全给根节点
		 * 少于1，则问根节点借1元，即为-1。
		 */
		if(root.left==null&&root.right==null) {
			return root.val-1; 
		}
		int left_sum=traverse(root.left);//左子树的流水总和
		int right_sum=traverse(root.right);//右子树的流水总和		
		k+=Math.abs(left_sum)+Math.abs(right_sum);//总的操作次数
		
		
		root.val +=left_sum+right_sum;
		
		return root.val-1;
	}
}
