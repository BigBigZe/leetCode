package sort.sort_implement;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] nums) {
		// TODO Auto-generated method stub
		mergeSort(0, nums.length-1, nums);
	}

	private void merge(int left, int mid,int right, int[] nums) {
		// TODO Auto-generated method stub
		int[] container = new int[right-left+1];
		int i = left,j = mid+1;
		int k=0;
		while(i<=mid&&j<=right) 
			container[k++] = nums[i]<nums[j]?nums[i++]:nums[j++];
		if(i<=mid)
			while(i<=mid)container[k++]=nums[i++];
		if(j<=right)
			while(j<=right)container[k++]=nums[j++];
		for(i = left,j=0;i<=right;i++,j++) {
			nums[i] = container[j];
		}
	}

	private void mergeSort(int left, int right, int[] nums) {
		// TODO Auto-generated method stub
		if(left>=right)return;
		int mid = (left+right)/2;
		mergeSort(left, mid, nums);
		mergeSort(mid+1, right, nums);
		merge(left,mid,right,nums);
	
	}

}
