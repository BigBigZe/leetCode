Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]<br>
Output: 1<br>
Explanation:<br>
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

Solution:

> 思路很简单，对于任意一个root来说，与改root相差最小的节点一定是root左子树中最大的那个节点或是右子树中最小的那个节点。

> 这里需要注意的是，最小值的保存问题，由于是int类型，即使使用了包装类也仍然无法改变递归函数之外的值，因此需要用一个载体保存。