package list.array.find_all_duplicates_in_an_array;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] visited = new int [nums.length];
        List<Integer> l = new LinkedList<>();
        for(int i:nums) {
        	if(visited[i]==1)l.add(i);
        	else visited[i] = 1;
        }
        return l;
    }
}
