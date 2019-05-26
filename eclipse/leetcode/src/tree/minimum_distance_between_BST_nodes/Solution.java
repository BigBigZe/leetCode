package tree.minimum_distance_between_BST_nodes;

import tree.TreeNode;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        TreeNode diff = new TreeNode(Integer.MAX_VALUE);
        diff(root,diff);
        return diff.val;
    }

	public void diff(TreeNode root, TreeNode diff) {
		// TODO Auto-generated method stub
		if(root==null||root.left==null&&root.right==null)return;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		if(root.left!=null)
			max = findmax(root.left);
		if(root.right!=null)
			min = findmin(root.right);
		
		if(Math.abs(root.val-max)<diff.val)diff.val=Math.abs(root.val-max);
		if(Math.abs(min-root.val)<diff.val)diff.val=Math.abs(min-root.val);
		
		diff(root.left,diff);
		diff(root.right,diff);
		
	}

	public int findmax(TreeNode root) {
		if(root.right!=null)return findmax(root.right);
		return root.val;
	}

	public int findmin(TreeNode root) {
		// TODO Auto-generated method stub
		if(root.left!=null)return findmin(root.left);
		return root.val;
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(4);
		r.left = new TreeNode(2);
		r.left.left = new TreeNode(1);
		r.left.right = new TreeNode(3);
		r.right = new TreeNode(6);
		System.out.println(new Solution().minDiffInBST(r));
	}
	void test(Integer i) {
		i=2;
	}
}
