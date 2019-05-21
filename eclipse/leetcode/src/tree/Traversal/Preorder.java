package tree.Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class Preorder {
    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode p = null;
		while(!stack.isEmpty()||p!=null) {
			if(p == null)
				p = stack.pop();
			res.add(p.val);
			if(p.right!=null)stack.push(p.right);
			p = p.left;
		}
		return res;
    }
    public void recursiveTraversal(TreeNode root) {
    	if(root==null)return;
    	System.out.println(root.val);
    	if(root.left!=null)recursiveTraversal(root.left);
    	if(root.left!=null)recursiveTraversal(root.right);
    }
    public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.right = new TreeNode(2);
		r.right.left = new TreeNode(3);
		new Preorder().iterativeTraversal(r);
	}
}
