package sort.sort_implement;

public class Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Sort box = new InsertSort();
		Sort box = new MergeSort();
		int[] nums = {5,11,11,1,1,2,0,0};
		box.sort(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}

}
