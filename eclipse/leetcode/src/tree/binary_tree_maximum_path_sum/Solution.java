package tree.binary_tree_maximum_path_sum;

import tree.TreeNode;

public class Solution {
	int max = -999999;
    public int maxPathSum(TreeNode root) {
    	maxPath(root);
        return max;
    }
    private int maxPath(TreeNode root) {
    	if(root==null)return 0;
    	max = max>root.val?max:root.val;
    	int l = maxPath(root.left);//到左儿子的最长路径
    	int r = maxPath(root.right);//到右儿子的最长路径
    	int temp = -9999999;
    	temp = temp>l?temp:l;
    	temp = temp>r?temp:r;
    	max = max>temp?max:temp;
    	if(l>0&&r>0)max=max>(l+r+root.val)?max:(l+r+root.val);
    	max = max>(temp+root.val)?max:temp+root.val;
    	if(temp>0)return temp+root.val;  	   	    	
    	else return root.val;
    }
}
