package chapter4.binarySearchTree;


import chapter4.binarySearchTree.TreeNode;;

public class Solution {

	public TreeNode deleteNode(TreeNode root , int key) {
        if(root==null)return null;
		if(root.val == key)return delete(root,key);
        else {
            delete(root,key);
            return root;
        }
	}
	
	/**
	 * delete the node which's value is equal to the key recursively
	 * @param root
	 * @param key
	 * @return
	 */
    public TreeNode delete(TreeNode root, int key) {
    	if(!contains(root, key))return null;
    	
    	if(root.val==key) {
    		//if root has no child
    		if(root.left==null&&root.right==null) {
    			return null;
    		}   
    		// if root has one child
    		else if(root.left!=null&&root.right==null) {
    			return root.left;
    		}else if(root.left==null&&root.right!=null) {
    			return root.right;
    		}
    		// if root has two children
    		else {
    			int val = findMin(root.right).val;
    			root.right = delete(root.right , val);
    			root.val = val;
    			return root;
    		}
    	}
    	/**
    	 * when the key is not equal to the value of the root,
    	 * then we should assign the result of  the function delete
    	 * to its child,then return it.
    	 */
    	else if(root.val>key) {		
    		root.left = delete(root.left, key);
    		return root;
    	}else	{
    		root.right = delete(root.right, key);
    		return root;
    	}
    
    }
    /**
     * Check whether the val is in the root
     * @param root
     * @param val
     * @return Boolean
     */
    public Boolean contains(TreeNode root,int val) {
    	if(root==null)return false;
    	if(root.val==val)return true;
    	else if(root.val>val)return contains(root.left, val);
    	else return contains(root.right, val);
    }
    
    /**
     * this method will return the minimized value of the root
     * @param root
     * @return TreeNode
     */
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
