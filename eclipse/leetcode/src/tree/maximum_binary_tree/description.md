Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.<br>
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.<br>
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.<br>
Construct the maximum tree by the given array and output the root node of this tree.

```
Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
```

Solution: 

好简单哦。。树的题只要搞懂递归，把递归表达式写清楚就行了。

一般的套路就是三步：
1. 处理根节点
2. 处理左子树
3. 处理右子树
4. 找出递归终止条件

放到这道题就是：
1. 根节点=当前数组中最大的值
2. 左节点=用根节点下标左边的子数组构造最大值二叉树
3. 右节点=用根节点下标右边的子数组构造最大值二叉树
4. 终止条件：子数组传入的头部坐标大于尾部坐标
