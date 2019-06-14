Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:<br>
Input: 2736<br>
Output: 7236<br>
Explanation: Swap the number 2 and the number 7.<br>

Example 2:<br>
Input: 9973<br>
Output: 9973<br>
Explanation: No swap.<br>

Note:
The given number is in the range [0, 108]

Solution:<br>
> 这道题思路应该还是很简答的，就是从后往前找到最大的数，然后从前往后找到第一个比最大的数小的数。但是做的时侯遇到了很多特别刁钻的测试用例，比如1993、99901、756776和98004365。

通过这几个测试用例来分析一下这个程序的一些细节：
1. 1993。这个测试用例的特殊在于中间有两个9，怎么取靠近3的那个9？

> 增加一个筛选过程，遇到重复数字一直跳过，然后取第一个（从后往前的第一个）

2. 99901。在从后往前到最大的数的过程中，很明显这个用例是0和1交换，那怎么保证取1的时候不取到9呢？

> 假设一个数有n位，第i位是找到的最大的数，其中前k位都比num[i]大且为非递增顺序（例如998871....6....），那么要做的就是让num[i]和num[k+1]进行交换。根据以上的结论可以增加一个筛选：当遇到比maxnum大的数时，一直往前判断，如果到达第一位时仍然保持非递减（从后往前为非递减，从前往后非递增），则maxnum保持不变。