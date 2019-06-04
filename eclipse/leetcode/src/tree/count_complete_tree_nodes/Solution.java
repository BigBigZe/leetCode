package tree.count_complete_tree_nodes;

import tree.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
    	if(root==null)return 0;
    	int max = LDeepth(root.left);
		int LDeepth = RDeepth(root.left);
		int RDeepth = LDeepth(root.right);
		if(LDeepth==0&&RDeepth==0)return 1;
		if(LDeepth<max)
			return (1<<RDeepth) + countNodes(root.left);
		else 
			return (1<<LDeepth) + countNodes(root.right);
        
    }
    public int LDeepth(TreeNode root) {
    	if(root==null) return 0;
    	if(root.left==null)return 1;
    	else return LDeepth(root.left)+1;
    	
    }
    public int RDeepth(TreeNode root) {
    	if(root==null) return 0;
      	if(root.right==null)return 1;
    	else return RDeepth(root.right)+1;	
    }
    public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left=new TreeNode(1);
		r.left.left=new TreeNode(1);
		r.left.right=new TreeNode(1);
		r.right=new TreeNode(1);
		r.right.left=new TreeNode(1);
	
		System.out.println(new Solution().countNodes(r));
		System.out.println(new Solution().countNodes(r.left));
		System.out.println(new Solution().countNodes(r.right));
	}
}
