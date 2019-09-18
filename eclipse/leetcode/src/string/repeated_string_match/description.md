Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

Solution:

这题很简单，关键是字符串长了怎么处理？也就是会存在常量池可能内存溢出的情况，最好的办法就是用StringBuilder，但是其中并没有contains方法，最初想到的是toString.contains，但是显然这样又会造成常量池溢出，后面看了下大佬的解答，发现原来还有lastIndexOf这么一个骚方法。

