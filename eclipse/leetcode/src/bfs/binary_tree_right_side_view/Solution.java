package bfs.binary_tree_right_side_view;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;
/**
 * 树的右视图
 * @author zone
 *
 */
public class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new LinkedList<Integer>();
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	if(root==null)return res;
    	int nums = 1;
    	list.add(root);
    	while(!list.isEmpty()) {
    		int i = nums;
    		nums = 0;
    		while(i>1) {
    			TreeNode t = list.remove(0);
    			if(t.left!=null) {
    				list.add(t.left);
    				nums++;
    			}
    			if(t.right!=null) {
    				list.add(t.right);
    				nums++;
    			}
    			i--;
    		}
			TreeNode t = list.remove(0);
			if(t.left!=null) {
				list.add(t.left);
				nums++;
			}
			if(t.right!=null) {
				list.add(t.right);
				nums++;
			}
    		res.add(t.val);
    	}
    	return res;
    }
    public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.right = new TreeNode(3);
		t.left = new TreeNode(2);
		t.left.right = new TreeNode(5);
		t.right.right = new TreeNode(4);
		new Solution().rightSideView(t);
	}
}
