package tree.Traversal;

import java.util.List;

import tree.TreeNode;

public interface Traversal {
    public void recursiveTraversal(TreeNode root);
    public List<Integer> iterativeTraversal(TreeNode root);
}
