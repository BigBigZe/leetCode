package sort.sort_implement;

public class InsertSort implements Sort {

	@Override
	public void sort(int[] nums) {
		// TODO Auto-generated method stub
		for(int times=1;times<nums.length;times++) {
			int temp = nums[times];
			int i=times;
			while(i>0&&nums[i-1]<temp) {
				nums[i]=nums[i-1];
				i--;
			}
			nums[i] = temp;
		}
	}

	

	

}
