Given a string, sort it in decreasing order based on the frequency of characters.

```
Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

```

Solution:

思路一看就很简单，就是用一个Hash表将不同的字符存起来然后进行counter，接着把counter的结果进行排序，之后输出。

我遇到的问题是提交上去第33个用例死活过不去，说超时。这个用例是一个巨长的字符串，而我一开始在counter的时候没有选择用数组，而是用HashMap，我就想是不是频繁地put/get可能会有问题，于是就在counter的时候换成了数组，结果还是过不去。最后看了网上的解答才发现输出不能直接用字符串类型，一直 += 操作会出问题。

大概就是这样，现在准备学一学StringBuilder、StringBuffer和String三者区别。