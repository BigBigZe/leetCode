Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

```
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
```

Solution:

其实做这题的前一天晚上已经有点头绪了，但二分插入又给我整忘了，今天看到优先级队列突然就来灵感了，花了也就半小时吧，就写出来了，不过效率确实是辣眼睛。

我的思路：先插入，再从插入的地方开始不断的去做区间合并。插入自然是用start为参照做二分插入。在插入完成以后，接着从插入的前一个位置来做区间合并，为什么要用前一个位置呢？因为newInterval可能刚好与前一个位置有交叉。合并的过程很简单，因为产生交叉的地方只可能从newInterval的前一个位置开始，所以只要产生交叉，就保留前一个interval的start，同时end = max(last.end,current.end)，最后删除掉current即可；如果没产生交叉，那么就让i++。

整个过程是特别繁琐的，而且14%的击败率主要原因在于：新建了一个类来保存<start,end>，比优化算法多遍历了一次；另外在采用Arraylist的时候，不断的有remove操作

优化算法：这个是我看大神提交的代码，确实不光代码量短，而且思路也很清晰。首先讲一点，list中的元素可以是数组（其实数组也是一种对象，我一开始还不知道）。然后直接开始遍历，就遍历一次！！！！每次遍历一个interval与newInterval进行比较，只有三种情况:
- 第一种newInterval完全在interval左边，即newInterval[1]<interval[0]，此时说明newInterval之后的所有interval全部没有交叉，直接暂停
- 第二种newInterval完全在interval右边，即newInterval[0]>interval[1]，此时说明newInterval与之前的interval也没有任何交叉，直接将其add到list中
- 最后一种二者有交叉，那就让newInterval[0]=min(newInterval[0],interval[0]);newInterval[1]=max(newInterval[1],interval[1])

当出现第一种情况时，跳出遍历，将newInterval加入list中后，再将剩余interval全部加入list。

整个过程只需一次遍历。这个方法巧妙在没有直接让数组再原有的基础上进行改变，而是牺牲一定的空间，将需要的interval进行存放，不需要的则不去考虑。

