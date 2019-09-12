Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

```
Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
```

Solution:

最初的思路是做一个词频统计，但是词频统计需要O(n)常数倍的复杂度，因为做完一次词频统计后，又需要逐一对两个字符串的剪子对进行比较，时间开销是很大的。

题中的方法实际上只对s做了一次遍历，想到最大数那个字符串的问题，有些时候可以直接对问题的子元素进行操作后进行判断，就比如说这道题，既然需要做一一映射，那么s[i]和t[i]则一定满足映射关系，那么只需要做一遍遍历检测是否所有字符都满足即可。

具体做法：
1. dict[i]用来保存s[i]的映射结果，flag[i]用来表示t[i]中使用过的元素
2. 如果dict[s[i]]==0，说明s[i]还没有进行过映射处理，此时判断对应的flag[t[i]]是否被使用，如果被使用过，则无法满足一一映射，返回false，否则令dict[s[i]]=t[i],flag[t[i]]=1
3. 如果dict[s[i]]!=0&&dict[s[i]]!=t[i]，显然也不是一一映射，直接返回false
