```
A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.


Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 

Note:

N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

```

Solution：

> 首先讲思路，一开始看到这道题最初萌生的想法是暴力！遍历每一个元素，每一个元素都去试一遍，然后想到“连通图”这个概念————比如说上面的例子5, 6, 2, 0得到的结果一致，因为他们处于一个连通图中，然后就产生了第一个版本：蜗牛版，这个版本中我采用了两个HashSet，分别记录已经出现的元素和每次产生的连通子图，但是效果很差36ms，才17.5%；接着我就想到第二个版本：龟速版，采用数组标记的方式来处理出现的元素，因为数组的随机访问是比HashSet快的多的，但是还是很垃圾，仍然在23ms，不过达到了23%；最后我觉得我思路上有问题，才打开大神们的答案看了下，发现思路还是一样的，只是他们所有集合的处理都是用visited数组来实现的，然后用计数器来计算连通子图的大小。

**爽！ 又学会了一招！！！**



