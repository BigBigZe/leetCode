package tree.Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class Postorder implements Traversal{
    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode p = null;
		while(!stack.isEmpty()) {
			p =  stack.pop();
			if(p.left!=null) {
				stack.push(p.left);
			}
			if(p.right!=null) {
				stack.push(p.right);
			}
			res.add(0,p.val);
		}
		return res;
    }
    public void recursiveTraversal(TreeNode root) {
    	if(root==null)return;

    	if(root.left!=null)recursiveTraversal(root.left);
    	if(root.left!=null)recursiveTraversal(root.right);
    	System.out.println(root.val);
    }
    public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.right = new TreeNode(2);
		r.right.left = new TreeNode(3);
		new Postorder().iterativeTraversal(r);
	}
}
