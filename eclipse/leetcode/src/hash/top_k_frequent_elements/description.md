Given a non-empty array of integers, return the k most frequent elements.

```
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
```

Note:

> - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 
Solution:
思路很简单，就是普通的词频统计题目，直接用O(n)遍历一遍把每个数字以及出现的次数记录到map，然后找出map种value最大的前k个key。

这里找的话，我图方便直接调用了list自带的sort方法，自然有些慢，需要多花费O(mlogm)的时间，m为不同数字的总量。

最快的top-k问题解决方法自然是桶排序，O(m)的复杂度，但今晚有些困，想到用桶，但不记得咋用了，没有深入下去。
