package sort.sort_implement;

public class InsertSort implements Sort {

	@Override
	public void sort(int[] nums) {
		for(int i=1;i<nums.length;i++)
		{
			int j=i;
			int tmp = nums[i];
			while(j>0&&nums[j-1]>tmp) {
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = tmp;
		}
	}

	

	

}
