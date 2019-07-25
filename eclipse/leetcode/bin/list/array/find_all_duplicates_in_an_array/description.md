Given an array of integers, **1 ≤ a[i] ≤ n (n = size of array)**, some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

**Could you do it without extra space and in O(n) runtime?**

```
Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
```
**Solution**

先说这道题吧，如果不给定数组大小以及元素大小的这两个个条件想要在O(n)做出来理论上是不可能的，可能有人会说用Set，但是Set的实现也并不是纯粹的O(1)。我这里一共给出三种解法，按巧妙程度从第一种到第三种进行说明。

1.排序。直接调Arrays自带的API进行排序，然后再依次遍历，显然这样是不需要用到额外空间的，但是排序最快也是O(nlgn)，可以说很垃圾了。

2.桶标记。为什么这里不同于一开始说的Set而可以用桶标记的方法？因为条件已经定好了每个元素的大小，所以可以用桶，而桶的话是随机访问，所以效率是极快的，但是仍然用了O(n)的额外空间。具体做法就是申请一个n+1大小的数组，然后依次遍历原数组，如果visited[nums[i]]==1，则说明之前出现过，否则置为1。这也是我提交的第一个版本的解法。

3.自己标记自己。什么叫做自己标记自己呢？其实这种方法与上一种类似，但是我们观察到数组中的元素全为正数，那这里就可以用一个小trick————我们通过改变其正负号来标记其是否访问过。
