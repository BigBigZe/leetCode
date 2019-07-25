Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

Solution：

这道题我想了挺久O(lgn)怎么去实现，因为可能出现一种极端情况比如[1,1,1,1,1]让你去找1，如果用常规的中部凿井法，先去index=3，再向前后遍历很容易就变成了O(n)。

我的想法其实很简单，就是用两次递归二分法，第一次找到target的左边界，第二次找到target的右边界。具体实现以寻找右边界为例：
> nums[mid]>target,则right=mid-1;nums[mid]<target,则left=mid+1;前面这两步跟二分法实际上一样，但是当nums[mid]=target时，我们会继续递归的在[mid,right]这个区间进行寻找，若返回-1，则说明右边界就为mid，否则为返回值。

这里因为一些细节，第一次跑直接跑飞了，我还以为思路有问题，然后看了下网上的，大部分用的都是中部凿井法，所以又仔细debug了一下，发现还是没有问题的，而且提交结果是98%。