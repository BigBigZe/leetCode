package sort.sort_colors;

public class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j) {
        	if(nums[i]==2) {
        		int temp = nums[j];
        		nums[j]=nums[i];
        		nums[i]=temp;
        		if(temp==0)i++;
        		j--;
        	}
        	else if(nums[i]==0)i++;
        	else {
        		int k = i+1;
        		while(nums[k]==1&&k<j)k++;
        		if(nums[k]!=1) {
	        		int temp = nums[k];
	        		nums[k] = nums[i];
	        		nums[i] = temp;
        		}
        	}
        }
    }
}
