package list.array.find_all_duplicates_in_an_array;

import java.util.LinkedList;
import java.util.List;

public class OptimalSolution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new LinkedList<>();
        for(int i:nums) {
        	int index=0,value=0;
        	value = Math.abs(i);
        	index = value-1;
        	if(nums[index]>0)nums[index] = 0-nums[index];
        	else l.add(value);
        }
        return l;
    }
}
