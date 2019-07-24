package tree.diameter_of_binary_tree;

import tree.TreeNode;

public class OptimalSolution {
	int max;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null)return 0;
		dfs(root);
		return 0;
    }
	private int dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		if(left+right>max)max = left + right;
		return Math.max(left, right)+1;
	}
}
