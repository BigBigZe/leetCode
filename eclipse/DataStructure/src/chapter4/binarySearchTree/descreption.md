这里主要介绍一下二叉搜索树的删除操作，其基本思路为：
1. 判断是否找到value,如果没有直接返回null
2. 找到的情况：<br>
 如果当前root没有孩子节点，则直接返回null<br>
 如果当前root只有一个孩子节点，则让root=root.left或root.right<br>
 如果当前root有两个孩子节点，则找到右孩子的最小节点放在root的当前位置，因为改最小节点满足大于root.left而小于root.right。