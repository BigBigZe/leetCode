package bfs.binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	int nums = 1;
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	
    	if(root==null)return res;
    	
    	List<TreeNode> list = new LinkedList<>();
    	
    	list.add(root);
    	while(!list.isEmpty()) {
    		List<Integer> container = new LinkedList<>();
    		int i = nums;
    		nums = 0;
    		while(i>0) {
    			TreeNode r = list.remove(0);
				container.add(r.val);
				if(r.left!=null) {
					list.add(r.left);
					nums++;
				}
				if(r.right!=null) {
					list.add(r.right);
					nums++;
				}
    			i--;
    		}
    		if(!container.isEmpty())res.add(container);
    	}
    	
		return res;

    }
}
