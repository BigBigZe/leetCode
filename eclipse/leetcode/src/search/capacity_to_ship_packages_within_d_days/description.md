A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

```
Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation: 
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 
Example 2:

Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation: 
A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation: 
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

```


**Solution**

这道题拖了快十天才想起来写总结。

刚碰到的时候确实是手足无措，不知道从哪里切入，完全看不出可以用二分法的地方，只是感觉跟那个猴子吃香蕉的题有点像，然后看了下网上的解答才明白了，现在回过头看这一类的问题确实还算比较简单。

先讲思路，在D天内找到一个最小的容量，使得所有货物能够全部送完，既然是找容量，那肯定是要确定上下界的，上界显然就是一天内能送的容量（所有货物的总和），即最快也需要在一天内送完，而下下界显然就是最慢的，即n个货物中最重的货物。这里可能不太好理解，我解释一下：要求的是一个集装箱的容量，那么这个集装箱最多也就一次把所有东西装完即我们的上界，而最少也要能装下所有货物中最重的那个即我们的下界。

确定完上下界，我们就用二分法找出我们想要的那个容量即可。那么什么是我们想要的容量呢？题目说了这个容量必须在D天之内把货装完，也就是说求出一个容量C，能够在n天内装完货物，要满足n<D，那这个C就是满足要求的。所以我们通过二分法去不断探索C，然后再模拟用C去装货的过程，求出n。如果n>D，就说明C取得太小，D天内装不完；如果n<D，则说明C取得太大。

其实这道题难的地方在于使用二分法的时候比较对象和查找对象是两个东西，比较的是模拟出来的天数，而查找的是最小的容量。