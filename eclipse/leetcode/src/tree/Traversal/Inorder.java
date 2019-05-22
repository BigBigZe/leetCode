package tree.Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class Inorder implements Traversal{

	@Override
	public void recursiveTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null)return;
		if(root.left!=null)recursiveTraversal(root.left);
		System.out.println(root.val);
		if(root.right!=null)recursiveTraversal(root.right);
	}

	@Override
	public List<Integer> iterativeTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		List<Integer> res = new LinkedList<>();
		if(root==null)return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(true) {
			while(p!=null) {
				stack.push(p);
				p = p.left;
			}
			if(stack.isEmpty())break;
			p = stack.pop();
			res.add(p.val);
			p = p.right;
		}
		return res;
	}
	   public static void main(String[] args) {
			TreeNode r = new TreeNode(1);
			r.right = new TreeNode(2);
			r.right.left = new TreeNode(3);
			new Inorder().iterativeTraversal(r);
		}
}
