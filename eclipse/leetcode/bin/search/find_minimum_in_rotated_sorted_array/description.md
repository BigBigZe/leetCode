Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

```
Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
```
Solution:<br><br>
	仍然采用二分法，因为中间的元素也符合二分的性质，即要么比两端的都小，要么比两端的都大。<br><br>
	当比两边都大的时候，则对右边的子数组进行二分搜索；当比两边都小的时候，则对左边的子数组进行二分搜索。