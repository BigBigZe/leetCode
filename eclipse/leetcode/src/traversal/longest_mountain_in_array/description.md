Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

```
Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
```

Note:

- 0 <= A.length <= 10000
- 0 <= A[i] <= 10000

Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?

Solution:

这题恶心的地方在于需要考虑到很多种情况，但碰了很多错误测试用例之后，就能发现实际情况一共就3种：上坡、平地和下坡。

考虑到我们的输出，起点一定是从上坡开始的，所以在探寻山脉开始之前，先要把下坡和平地走完，因此有了第一个while；此时我们记录下起点，然后开始走上坡，这里就有了第二个while；当上坡停下之后，我们需要判断前方是否是下坡，如果是下坡，那么直接走完，并用终止坐标和起点求出山脉长度同时记录；否则重新进入下一轮循环。

