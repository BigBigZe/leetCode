Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: [1,2,3,4,5,6,null,null]

Output: 6

**Solution:** <br>

一看题目就知道肯定不能用n(l)+n(r)+1这种形式来解（显然这种为O(n)的复杂度是最慢的）

分析完全二叉树的结构，可以知道，一个完全二叉树的每个子树也都是一个完全二叉树。由这点可以知道用递归。

再考虑右子树和左子树的关系，会发现右子树无论如何节点总数一定是比左子树少的，而最深的节点一定是在最左边。

所以可以比较每个左子树最右边的深度（LDeepth）和最大深度（max）的关系：
1. 若LDeepth<max，那显然右子树是一个满二叉树（叶子缺失最早出现在左边），算上根节点的数目可以直接表示为 2的RDeepth次方，然后再加上countNode(root.left)即可
2. 若LDeepth==max，那显然左子树是一个满二叉树，则反过来即可。


