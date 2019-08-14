You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.


```

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

```

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

Solution:

感觉Hash的题基本都是一个套路，就是准备好一个字典，然后对这个字典进行操作然后解决问题。

这道题的思路：先用一个长度为10的数组做字典（0-9），然后统计好secret中每一种数字的个数。接着再对guess遍历两次，第一次统计BULL(相同位置相同数字)的个数，第二次统计COW（不同位置相同数字）的个数，只要dict中对应位置大于0，相应的A或B就进行+1操作，而dict对应位置就进行-1操作。

这里有个小trick是我看提交的前90%的代码发现的，遍历secret的时候不用单独做一次foreach操作，直接放在guess的第一次遍历即可，因为题目说了guess和secret是等长的。
