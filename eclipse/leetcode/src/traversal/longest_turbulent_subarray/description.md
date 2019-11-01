A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.


``` 

Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
Example 2:

Input: [4,8,12,16]
Output: 2
Example 3:

Input: [100]
Output: 1


Note:

1 <= A.length <= 40000
0 <= A[i] <= 10^9
```

Solution:

这道题和那个最长山脉其实类似。做这种一维数组的遍历题，首先得明确一点那就是最优解一定是在O(n)内完成，超过O(n)那就很麻烦了，O(lgn)那是二分查找不是遍历。

这种题的关键就是找准状态：如果是湍流子数组，那么里面的每一个元素A[i]必须满足A[i-1]<A[i]>A[i+1]或A[i-1]>A[i]<A[i+1]，因此记录比较状态是最重要的，我们需要用一个符号Op记录下前一位的比较状态，然后和后一位进行比较；而A[i]与A[i+1]的关系应该始终与A[i]和A[i-1]的关系相反，并且不能相等。

这里我采用了一个非常巧妙的替代法来解决这种状态问题（本题的两个状态为> 或 <），即用奇偶数代替。数字的好处在于做变化状态时，无论哪种状态都只用进行+1操作然后取模即可。

然后我们开始找最大值：
1. 首先需要将==的值过滤干净
2. 然后进行初始化：以当前的i为起始点，同时判断A[i]和A[i+1]的关系，并给op进行初始化（注意op记录的是A[i]和A[i-1]的关系）
3. 开始遍历，当A[i]和A[i+1]满足与op相反的关系时，op++并且i++
4. 否则跳会第一步重新开始初始化

