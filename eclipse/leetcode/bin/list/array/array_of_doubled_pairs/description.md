Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

```
Example 1:

Input: [3,1,3,6]
Output: false
Example 2:

Input: [2,1,2,6]
Output: false
Example 3:

Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: [1,2,4,16,8,4]
Output: false
 

Note:

0 <= A.length <= 30000
A.length is even
-100000 <= A[i] <= 100000

```
Solution:

>	这道题一开始想的复杂了，觉得肯定不能用普通的遍历求，然后想了半天也想不出，后面看了网上答案还是用遍历，但是JAVA的垃圾数据结构死活也跑不完所有测试用例，

> 讲下基本思路:先排序（注意正负数要分开放），然后遍历前length/2的数，只要数组中存在2*list.get(i)，就把这个数删除，然后往后挪。但是JAVA很垃圾，直接超时了。最后直接交了个别人的cpp上去。