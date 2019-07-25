Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

Solution:
> 递归法的思路很简单，就是不断通过前一个传进来的path+"->"+root.val，而停止条件就是root为叶子节点，否则就将path 继续传给左右孩子。
