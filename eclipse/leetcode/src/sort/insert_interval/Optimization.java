package sort.insert_interval;

import java.util.ArrayList;

public class Optimization {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int i;
		ArrayList<int[]> list = new ArrayList<>();
		for(i=0;i<intervals.length;i++) {
			if(newInterval[1]<intervals[i][0])break;
			else if(newInterval[0]>intervals[i][1])list.add(intervals[i]);
			else {
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			}
		}
		list.add(newInterval);
		while(i<intervals.length)
			list.add(intervals[i++]);
		int [][] res = new int[list.size()][];
		for(i=0;i<res.length;i++)
			res[i] = list.get(i);
		return res;
	}
}
