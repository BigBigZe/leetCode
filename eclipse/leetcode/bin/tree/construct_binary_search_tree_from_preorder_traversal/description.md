Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

**Example:**<br>
input:[8,5,1,7,10,12]<br>
output:

<img src=https://assets.leetcode.com/uploads/2019/03/06/1266.png>

**Solution:**

	这道题的基本思路就是分治————为左子树构造二叉树，然后为右子树构造二叉树。<br>
	很容易发现前序遍历的序列有一个规律：根节点永远在最前面，然后整个数组左边一部分为左子树，右边一部分为右子树，那么根据分治的思想，可以分为：
	- [8]:构造根节点
	- [5,1,7]:构造左子树
	- [10,12]:构造右子树<br>
	然后继续分治，直到分不了为止。
	