package bfs.binary_tree_zigzag_level_order_traversal;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(root==null)return res;
    	int nums = 1,direct=1;
    	List<TreeNode> list = new LinkedList<>();
    	list.add(root);
    	
    	while(!list.isEmpty()) {
    		List<Integer> tmp = new LinkedList<>();
    		int i = nums;
    		nums = 0;
    		if((direct&1)==1) {
        		while(i>0) {
        			TreeNode r = list.remove(0);
        			tmp.add(0,r.val);
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
    		}else {
        		while(i>0) {
        			TreeNode r = list.remove(0);
        			tmp.add(r.val);
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
    		}
    		direct++;
    		if(!tmp.isEmpty())res.add(tmp);

    	}
    	
		return res ;
    }
}
