给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。

找出 A 中的坡的最大宽度，如果不存在，返回 0 。

```

示例 1：

输入：[6,0,8,2,1,5]
输出：4
解释：
最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.

示例 2：

输入：[9,8,1,0,1,9,4,0,4,1]
输出：7
解释：
最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.

 

提示：

    2 <= A.length <= 50000
    0 <= A[i] <= 50000

```

Solution:

1. 暴力法 。 最开始用的就差不多暴力法吧，稍微优化了一点点，但是头部遍历是O(n)，尾部差不多平均要O(0.25n2)

2. 单调栈。单调栈我一直没搞懂。。。不是没搞懂，是不会根据具体问题应用。
很简单，左边用递减栈把小的存好，然后右边一次遍历