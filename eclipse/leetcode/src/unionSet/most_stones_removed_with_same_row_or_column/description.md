在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。

现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。

我们最多能执行多少次 move 操作？

```

示例 1：

输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
输出：5

示例 2：

输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
输出：3

示例 3：

输入：stones = [[0,0]]
输出：0

 

提示：

    1 <= stones.length <= 1000
    0 <= stones[i][j] < 10000

```

Solution:

并查集！还是不熟悉，需要知道的是并查集始终是一维的，如果遇到二维的问题需要将其转化为一维来处理，就如这道题，题目有限定是10000，那么可以将列转化为10000+j，就可以表示第j列和第i行是连通的