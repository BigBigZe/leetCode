package list.array.Remove_Duplicates_from_Sorted_Array_II;

public class OptimalSolution {
	public int removeDuplicates(int[] nums) {
		int counter = 0;
		for(int i:nums) {
			if(counter<2||i>nums[counter-2])nums[counter++] = i;
		}
		return counter;
	}
}
