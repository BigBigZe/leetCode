package sort.sort_implement;

import java.util.Arrays;

public class QuickSort implements Sort{

	@Override
	public void sort(int[] nums) {
		// TODO Auto-generated method stub
//		quickSort(0, nums.length-1, nums);
		quickSort(nums, 0, nums.length-1);
//		Arrays.sort(nums);
	}
	
	//要记住的是，每一轮的pivot都能被确定好
	private void quickSort(int i, int j, int[] nums) {
		if(i>=j)return;
		// TODO Auto-generated method stub
		int low = i,high = j-1;
		if(nums.length==0||nums.length==1)return;
		int pivot = j;
		while(low<=high) {
			if(nums[low]<=nums[pivot])low++;
			else {
				int temp = nums[high];
				nums[high--] = nums[low];
				nums[low] = temp; 
			}
		}
		int temp = nums[pivot];
		nums[pivot] = nums[low];
		nums[low] = temp;
		quickSort(i,low-1,nums);
		quickSort(low+1,j,nums);
	}
	
	//填坑法
	private void quickSort(int nums[],int left,int right) {
		if(left>=right)return;
		int pivot = nums[left];
		int j=right,i=left;
		while(i<j) {
			while(i<j&&nums[j]>=pivot)j--;
			if(i<j)nums[i++]=nums[j];
			while(i<j&&nums[i]<pivot)i++;
			if(i<j)nums[j--]=nums[i];
		}
		nums[j] = pivot;
		quickSort(nums, left, j-1);
		quickSort(nums, j+1, right);
	}

}
