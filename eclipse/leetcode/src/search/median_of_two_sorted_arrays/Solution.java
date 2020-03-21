package search.median_of_two_sorted_arrays;
/**
 * 从两个排序数组中找中位数
 * @author zone
 *
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int n = nums1.length+nums2.length;
    	return (find(nums1,0,nums2,0,(n+1)/2)+
    			find(nums1,0,nums2,0,(n+2)/2))/2.0;   
    }

	private int find(int[] nums1, int i, int[] nums2, int j, int k) {
		// TODO Auto-generated method stub
		if(i>=nums1.length)return nums2[j+k-1];
		if(j>=nums2.length)return nums1[i+k-1];
		if(k==1)return Math.min(nums1[i], nums2[j]);
		int m1 = i+k/2-1<nums1.length?nums1[i+k/2-1]:Integer.MAX_VALUE;
		int m2 = j+k/2-1<nums2.length?nums2[j+k/2-1]:Integer.MAX_VALUE;
		
		if(m1<m2)return find(nums1, i+k/2, nums2, j, k-k/2);
		else return find(nums1, i, nums2, j+k/2, k-k/2);
		
	}
}
