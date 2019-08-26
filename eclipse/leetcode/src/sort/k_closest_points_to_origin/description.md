We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

```
 
Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
```

Solution:

基本思路就是求出distance然后排序，但是有两个麻烦的地方：
- 坐标的排序如何记录下标
- 找出前K个可能不一定要全部排序

我在这两个问题上都卡了很久，后面干脆不记录下标，直接在二维数组上进行快排操作，即将第二个维度看作一个整体，然后快排的部分对“K”进行了优化，当pivot的下标比K大时，就只需要排pivot左边那部分，这是基于快排的特点——每次都能将一个pivot的最终确定下来。
