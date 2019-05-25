package tree.binary_tree_paths;

import java.util.LinkedList;
import java.util.List;


import tree.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
    	String path = root.val+"";
    	List<String> l = new LinkedList<>();
    	findPath(l,root.left,path);
    	findPath(l,root.right,path);
    	return l;
    }
    public void findPath(List<String> l,TreeNode root,String path) {
    	if(root==null) return;
    	String currentPath = path+"->"+root.val;
    	if(root.left==null&&root.right==null) {
    		l.add(path+"->"+root.val);
    		return;
    	}
    	findPath(l, root.left, currentPath);
    	findPath(l, root.right, currentPath);
    }
    public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		r.left.right = new TreeNode(5);
		List<String> l = new Solution().binaryTreePaths(r);
		for (String s : l) {
			System.out.println(s);
		}
    }
}
