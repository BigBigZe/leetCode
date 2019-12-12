给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。

找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。

（小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）

示例：
![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/02/tree3.png)

```
输入：[2,2,1,null,1,0,null,0]
输出："abc"
```

![image](https://note.youdao.com/yws/public/resource/9cedcf40a3147638e72cd927b76fa9aa/xmlnote/FABAE1317FBF4FE5BAA8A39975480D87/28364)

```
输入：[25,1,null,0,0,1,null,null,null,0]
输出："ababz"
```

Solution:
这道题骚在一定要遍历到底才能完全确定最短的那个路径，比如示例二，从第二层来看的话，局部最优解应该是在最右边，因为ab<abab，但是没有把前面的祖先节点加进去。因此这里需要用一个全局变量去做记录。！！！