package bfAnddf.maximum_level_sum_of_a_binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class Solution {
    public int maxLevelSum(TreeNode root) {
    	int level = 0;
    	int maxLevel = 0,  maxSum=0;
    	if(root==null)return maxLevel;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int sum = 0;
    		int size = queue.size();
    		while(size>0) {
    			TreeNode t = queue.poll();
    			sum+=t.val;
    			if(t.left!=null)queue.add(t.left);
    			if(t.right!=null)queue.add(t.right);
    			size--;
    		}
    		level++;
    		if(sum>maxSum) {
    			maxLevel=level;
    			maxSum=sum;
    		}
    	}
        return maxLevel;
    }
}
