'''
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
'''
class Solution:
    def numSquares(self, n: int) -> int:
        array = [9999 for i in range(n+1)]
        array[1] = 1
        seed = 2
        if n <= 1:
            return 1
        elements = list()
        elements.append(1)
        i = 2
        while i<=n:
            j = len(elements)-1
            if seed * seed == i:
                array[i] = 1
                elements.append(seed * seed)
                seed = seed +1

            else:
                while j>=0:
                    temp = array[i-elements[j]]
                    array[i] = min([array[i],temp+1])
                    j = j-1
            i = i+1
        return array[-1]

obj = Solution()
print(obj.numSquares(17))
        