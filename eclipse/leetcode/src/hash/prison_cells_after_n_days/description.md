There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

```
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
```

Solution:

逻辑很简单 cell[i] = (cell[i-1]&&cell[i+1])||(!cell[i-1]&&!cell[i+1])

最傻的就是O(8n)，每次做一遍逻辑运算，算n次。

然后发现数组大小为8，用二进制表示一共也就256个数，说明会有重复状态。

接着就是利用Hash去把重复状态和相应的天数进行存储就行。

我这里用了两个字典来做day——key的一一映射，网上应该有更简洁的方法。

按照天数，进行状态机的转换，没出现过的状态进行相应的存储，一旦出现重复状态就停止。（状态我采用的是数组表示的二进制的值）

接着用输入的N去对应相应的状态。

最难的其实就是最后一步，因为需要考虑到：
- 一共有多少种状态
- 从第几天开始进入重复状态的起点
- 如何计算N循环了几轮

举个例子来说明：

```
一共15个状态，其中s0为输入状态即第0天的状态，求第n天的状态：

 s0【s1.....s14】

s表示一个state，【】表示出现状态循环，即第1天开始进入循环，而到了第14天一轮状态结束。
而到了第15天又会到状态s1，那么很容易得到一个规律，第n天的状态是s(n%14)。

放到更一般的情形：
s0...【si....sk】

一共有k+1种状态，从第i天开始进入循环，那n天的状态显然就是s((n-i)%(k+1-i)+i)
```

最后这个取模公式调了我俩小时，我是真的服。。。

