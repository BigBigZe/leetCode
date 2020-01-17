package tree.sum_root_to_leaf_numbers;

import tree.TreeNode;

public class Solution {
	
	int sum = 0;
	
    public int sumNumbers(TreeNode root) {
        travel(root,0);
    	return sum;
    }

	private void travel(TreeNode root,int counter) {
		// TODO Auto-generated method stub
		if(root.left==null&&root.right==null) {
			sum+=counter*10+root.val;
			return ; 
		}
		if(root.left!=null)travel(root.left, counter*10+root.val);
		if(root.right!=null)travel(root.right, counter*10+root.val);
		
	}
}
