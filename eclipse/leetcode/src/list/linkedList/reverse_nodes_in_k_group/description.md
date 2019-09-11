Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

```
Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
```

Solution:

这题其实跟普通的反转链表很像，只是基于原来的基础上加了一个group，那么按照这个思路就可以先将原链表分成很多的group，然后将每个group分别反转，最后将反转后的子链表相连。