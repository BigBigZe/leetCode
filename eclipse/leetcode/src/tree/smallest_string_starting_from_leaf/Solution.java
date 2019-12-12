package tree.smallest_string_starting_from_leaf;

import tree.TreeNode;

public class Solution {
	String min="zzzzz";
    public String smallestFromLeaf(TreeNode root) {
    	findSmall(root,(char)(root.val+'a')+"");
        return min;
       
    }
	private void findSmall(TreeNode root,String pre) {
		// TODO Auto-generated method stub
		if(root==null)return;
		String current = (char)(root.val+'a')+pre;
		if(root.left==null&&root.right==null) {
			min = min.compareTo(current)<0?min:current;
			return;
		}
		if(root.left!=null)findSmall(root.left, current);
		if(root.right!=null)findSmall(root.right, current);	
	}
}
