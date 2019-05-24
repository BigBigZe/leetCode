package tree.remove;


import tree.TreeNode;

public class Solution {
	public TreeNode deleteNode(TreeNode root , int key) {
		root = delete(root ,key);
		return root;
	}
    public TreeNode delete(TreeNode root, int key) {
    	if(!contains(root, key))return null;
    	
    	if(root.val==key) {
    		if(root.left==null&&root.right==null) {
    			return null;
    		}   			
    		else if(root.left!=null&&root.right==null) {
    			return root.left;
    		}else if(root.left==null&&root.right!=null) {
    			return root.right;
    		}else {
    			int val = findMin(root.right).val;
    			root.right = delete(root.right , val);
    			root.val = val;
    			return root;
    		}
    	}
    	else if(root.val>key) {		
    		root.left = delete(root.left, key);
    		return root;
    	}else	{
    		root.right = delete(root.right, key);
    		return root;
    	}
    
    }
    public Boolean contains(TreeNode root,int val) {
    	if(root==null)return false;
    	if(root.val==val)return true;
    	else if(root.val>val)return contains(root.left, val);
    	else return contains(root.right, val);
    }
    public TreeNode findMin(TreeNode root) {
    	if(root.left==null)return root;
    	else return findMin(root.left);
    }
    public static void main(String[] args) {
		TreeNode r = new TreeNode(3);
		r.left = new TreeNode(1);
		r.right = new TreeNode(4);
		r.left.right = new TreeNode(2);
//		r.left.left = new TreeNode(2);
//		r.right.right = new TreeNode(7);
		new Solution().deleteNode(r, 2);
	}
}
