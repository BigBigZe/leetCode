package sort.sort_implement;

public class ShellSort implements Sort {

	@Override
	public void sort(int[] nums) {
		// TODO Auto-generated method stub
		
		
		
		for(int gap = nums.length/2;gap>0;gap /= 2) {
			for(int i = gap;i<nums.length;i++) {
				int j = i;
				int tmp = nums[i];
				while(j-gap>=0&&nums[j-1]>tmp) {
					nums[j] = nums[j-gap];
					j -= gap;
				}
				nums[j] = tmp;
			}
		}
	}

}
