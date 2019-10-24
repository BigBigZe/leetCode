package tree.maximum_binary_tree;

import tree.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	
        return createMaxTree(nums,0,nums.length-1);
    }

	private TreeNode createMaxTree(int[] nums, int low, int high) {
		if(low>high)return null;
		int index = -1,temp = Integer.MIN_VALUE;
		for(int i = low;i<=high;i++) {
			if(temp<nums[i]) {
				temp = nums[i];
				index = i;
			}		
		}
		TreeNode root = new TreeNode(nums[index]);
		root.left = createMaxTree(nums, low, index-1);
		root.right = createMaxTree(nums, index+1, high);
		// TODO Auto-generated method stub
		return root;
	}

    
    
    
}
