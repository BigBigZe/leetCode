package sort.sort_implement;

public class BubbleSort implements Sort {

	@Override
	public void sort(int[] nums) {
		// TODO Auto-generated method stub
		for(int i = 0;i<nums.length;i++) {
			
			for(int j = i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
	}

}
