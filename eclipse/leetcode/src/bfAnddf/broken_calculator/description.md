On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.

```

Example 1:

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: X = 5, Y = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Example 4:

Input: X = 1024, Y = 1
Output: 1023
Explanation: Use decrement operations 1023 times.

```


##### 广度优先搜索

可以观察到，X每次进行两次操作可以产生两个值，一个是X-1，一个是X*2，同理这两个值可以产生另外四个值。说明这个解空间可以是一个完全二叉树。我们通过把每次新生成的值放在一个队列尾部，最终总能遍历到正确的值。

但是显然这个算法是空间爆炸的，如果Y过大，那么每次翻倍会导致内存溢出

##### 数学方法

考虑到如果X<Y的话，有两种方法到达Y，一种是(X+K)*2=Y，而另一种是2X+2K=Y，显然第一种只需要K+1步，而第二种需要2K+1步。

除了对 X 执行乘 2 或 减 1 操作之外，我们也可以对 Y 执行除 2（当 Y 是偶数时）或者加 1 操作。

这样做的动机是我们可以总是贪心地执行除 2 操作：

- 当 Y 是偶数，如果先执行 2 次加法操作，再执行 1 次除法操作，我们可以通过先执行 1 次除法操作，再执行 1 次加法操作以使用更少的操作次数得到相同的结果 [(Y+2) / 2 vs Y/2 + 1]。

- 当 Y 是奇数，如果先执行 3 次加法操作，再执行 1 次除法操作，我们可以将其替代为顺次执行加法、除法、加法操作以使用更少的操作次数得到相同的结果 [(Y+3) / 2 vs (Y+1) / 2 + 1]。


