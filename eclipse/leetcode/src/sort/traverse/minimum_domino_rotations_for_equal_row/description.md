In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

```

Example 1:



Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
```

Note:

1 <= A[i], B[i] <= 6 <br>
2 <= A.length == B.length <= 20000

Solution:

1. 桶排序计算出可能满足的值（A和B中加起来个数超过数组长度的数a）
2. 分别统计A交换需要的次数以及B交换需要的次数

难的地方在想到桶排序可以直接找出biase，因为一个数的个数范围只能为0-2length，而要想满足题目条件则必须>=1 length。

特殊情况是有两个biase都为1 length,如果他们存在重叠情况即A[i]=B[i],那么就不成立；如果都是交叉存在的即A[i]!=B[i]，则成立，此时任意一个biase都可以作为题设进行计算并且结果一致。
