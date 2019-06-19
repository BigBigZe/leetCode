Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

Solution:<br>
> 最初的傻瓜方法就是每次找到超过2次的数都进行一次移位操作，这个代价显然为O(n)，而且在移位过程中需要注意到移位指针的上界（什么时候停下），过程太愚蠢不做阐述

**大神解法**<br>
> 代价为O(n)。
1. 定义一个counter，作为最终结果的计数器。
2. 遍历nums，只要当前的nums[i]>nums[i-2]，就让nums[counter]=nums[i]，同时让counter++

> 解释一下：当num[i]不满足 nums[i]>nums[i-2]时，说明只能是nums[i]==nums[i-2]（升序数组），那么counter需要保持不变，从而跳过超过两次的重复数字；而一旦满足条件，此时counter刚好在下一个可移动位上。

> 不知道这样解释行不行，反正我自己挺懵的。
