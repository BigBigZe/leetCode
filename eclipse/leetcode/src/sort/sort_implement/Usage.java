package sort.sort_implement;

public class Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort box = new InsertSort();
		int[] nums = {3,2,1};
		box.sort(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}

}
