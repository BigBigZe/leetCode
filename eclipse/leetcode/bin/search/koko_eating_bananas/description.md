Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.

```
Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23

Note:

1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9
```

Solution:<br><br>
	刚看这道题的时候大概是九点左右，贼想睡觉，漏看了条件，以为是刚好能在H小时内吃完的K的最小值，还以为是DP的解法，想了半天，结果一看网上的答案，是二分搜索，再看了下题目，觉得自己贼傻逼。<br>
	其实这道题的思路很简单，既然告诉你要在H内吃完即可，那么k的下界显然为1，k的上界显然是大于等于数组中的最大的那个数（最快H也得为数组大小），那么确定了两端，只用在[min,max]中找到一个临界值，使得这个临界值的右侧都可以满足H，而左侧都不可以满足H即可。
	<br>
	需要注意的是：<br>
-    在二分操作中，max = mid-1是不对的，因为mid可能刚好是临界值，而mid-1会把该值跳过
-  在计算时间的时候，注意取整的问题，当pile<=K时，需要进行+1操作
-  网上大多的解法第一步是先把数组排序，这说明网上的人都是互相借鉴吧，很明显找一个最大值的复杂度O(n)是远远小于排序的O(nlgn)的
	