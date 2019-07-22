Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

```
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
```

**Solution：**<br>
	先解释一下回文子串的长度，回文子串的长度要么为奇数，要么为偶数。如果为奇数，则说明构造它的字母元素中，有且仅有一个字母的个数是奇数（如果这个不能理解，可以尝试自己动手写一写），其余全为偶数个数。<br>
	再说这道题的思路，很明显就是通过遍历字典去挑出足够多的字母来构造，而字母的个数如果为奇数，则取总量减一（选去偶数个），同时再设定一个全局flag，假定遇到一个奇数个的字母，则最后输出加1。
>	比如：a:3,b:5,c:4,d:9

>	显然最后取得的为：2a+4b+4c+8d+(1a或1b或1d作为对称轴)

这里主要说下字典的选去，最好的方法是用一个数组，而不是自带的map。因为数组的随机访问远远快于map，而使用的方法只需要根据ASCII码的总量来设定数组大小。
	