package traversal.interval_list_intersections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<int[]>();
        int i=0,j=0;
        while(i<A.length&&j<B.length) {
        	int low = Math.max(A[i][0], B[j][0]);
        	int high = Math.min(A[i][1], B[j][1]);
        	if(low<=high) {
        		int[] tmp = {low,high};
        		list.add(tmp);
        	}
        	if(A[i][1]<=B[j][1])i++;
        	else j++;
        }
        int[][] a = new int[list.size()][];
        for(i = 0;i<list.size();i++)a[i] = list.get(i);
    	return  a;
    }
}
