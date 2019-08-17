Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

Solution:

其实一开始我想到的是用之前的单调栈，但是想到这题是分在散列里面的而且单调栈都忘的差不多了，于是一开始的思路就是用HashMap实现：从后往前遍历，把tempreture-day放入map中，然后每次在map中找到最小的比当前温度大的值，再算出其天数差。

看了大神的代码，果然效率吊打吾等渣渣。其实思路很简单，也是从后往前遍历，但是找临界值的方法却很巧妙：

```
要寻找比第i天热的最近的一天，那就从第i+1天开始往后找。

如果往后遍历到第j天比第i天温度高，则output[i]=j-i。

如果第j天比第i天温度低，且output[j]==0，那由于T[j]<T[i],所以output[i]=0

那如果第j天比第i天的温度低并且output[j]==X(X!=0)，那显然可以直接让T[i]和T[j+X]进行比较，
也就是进行一次j+=output[j]操作。
```