1. linkedList是以双向链表的结构实现的，具有双向链表的所有特性（first,last..）
2. 实现了queue接口，具有queue的特性，包括push、pop
3. 内部类:Node以及三个不同迭代器的实现类
4. 迭代器部分：只有当调用了next()后才允许使用remove()
基本逻辑为:1->2->3，此时iterator指向1；调用next()后指向2，返回的是1；再调用remove()，
删除的是刚才返回的1，而iterator不会再移动；如果此时再调用remove()，则会抛出java.lang.IllegalStateException，因为在调用remove()之前没有调用next()，此时
2前面已经没值了。


> 书p53:在操作链表的时候，可以考虑在头部或尾部加上一个无效节点，这样做的好处是：可以排除遍历到头或尾的特殊情形，而全部当一般情形考虑。
可见 ：/leetcode/src/list/linkedList/RemoveNthNodeFromEndofListM/ySolution.java 这道题的解法。