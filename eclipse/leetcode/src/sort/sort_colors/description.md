Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]<br>
Output: [0,0,1,1,2,2]

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.<br>
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.<br>
Could you come up with a one-pass algorithm using only constant space?

Solution:

提示说了最简单的就是用Counter然后两遍遍历，那显然复杂度是O(2n)。

一遍遍历的方法类似于快排的思想，可以将1想成pivot，然后从左往右遍历，遇到2就往右边放，遇到0就往左边放，用i和j分别记录当前的0和2的位置，然后遇到1的话，就继续遍历到下一个非1的数。这是我的解法。

思路更清晰的解法：三个指针，两个专门记录0和2的存放位置，一个用来进行遍历数组。遇到0就和左边替换，遇到2就和右边替换，遇到1就不做处理。