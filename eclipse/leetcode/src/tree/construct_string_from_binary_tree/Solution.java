package tree.construct_string_from_binary_tree;

import tree.TreeNode;
/**
 * 输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

输出: "1(2()(4))(3)"
 * @author zone
 *
 */
public class Solution {
	StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
    	f(t);
    	return sb.toString();
    }
	private void f(TreeNode t) {
		// TODO Auto-generated method stub
    	if(t==null)return;
    	sb.append(t.val);
    	if(t.left==null&&t.right!=null)
    		sb.append("()");
    	if(t.left!=null) {
    		sb.append("(");
    		tree2str(t.left);
    		sb.append(")");
    	}
    	
    	if(t.right!=null) {
    		sb.append("(");
    		tree2str(t.right);
    		sb.append(")");
    	}
	}
}
