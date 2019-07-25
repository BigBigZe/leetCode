Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

```
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

```

Solution:

第一种解法：暴力。暴力就不用说了吧？O(n2)两层循环

第二种解法：二分。二分是这里题目要求的O(nlgn)，出现lgn这种东西那大概率就离不开二分了。我没看别人怎么做二分的，我这里讲下我的思路，首先求出0-i的和，存放在一个sum数组中，这个只用花O(n)，接下来只用找使得sum[i]-sum[j]>s的最大的j的值（显然j最大的话，i-j就会最小），而找j的过程显然用二分法，具体细节我就不介绍了，我自己都写的乱七八糟的。但是这个总的时间应该平均要小于O(nlgn)的。

第三种解法：滑动窗口。这里窗口的size很特殊，并不是元素的个数，而是窗口内元素之和要>=s，这个应该很好理解，而我们最后返回的就是窗口内元素的个数了。思路很简单，就是当窗口内元素之和大于s的时候，left向右移，而right保持不动；当元素之和小于s的时候，right向右移，而left保持不动。

第三个解法也是看了评论提到滑动窗口这么个玩意儿，才想到的，但没看别人怎么实现，自己反正做出来就是O(n)。