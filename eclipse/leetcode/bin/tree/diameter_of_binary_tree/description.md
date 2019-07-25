Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

```
Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

```

Solution:

树的遍历问题一半都是递归来解，这道题思路很简单，直径只存在于三个地方：
1. 左子树的直径+1
2. 右子树的直径+1
3. 左子树的深度+右子树的深度

从上面三个值找出最大的即为该树本身的直径。

而我第一次的解法虽然简单通俗易懂（基本是把上面的复现了），但是重复计算了（深度计算的时候）。

大神的解法是用一个全局变量来解决的。