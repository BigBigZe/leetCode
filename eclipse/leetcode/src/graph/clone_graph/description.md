Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

![image](https://assets.leetcode.com/uploads/2019/11/04/133_clone_graph_question.png)

```
Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.

```

Solution：

含环的图如果直接遍历是一定会造成死循环的，解决的方式就是做标记。

因为这道题是直接给的其中一个节点，因此无法直接用数组，这里可以采用map进行标记。

标记完之后可以深度遍历，先拷贝其值，再拷贝其邻居链表；如果邻居链表中的节点未曾访问过，则递归拷贝该节点，否则直接拷贝之前map中存的引用。