package sort.insert_interval;

import java.util.ArrayList;
import java.util.List;
class Interval{
	int end;
	int start;
	public Interval(int start,int end) {
		this.start = start;
		this.end = end;
	}
}

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res=null;
        List<Interval> list = new ArrayList<>();
        for(int[] interval: intervals)
        	list.add(new Interval(interval[0], interval[1]));
        
        int l=0,h=list.size()-1;
        while(l<=h) {
        	int m=(l+h)/2;
        	Interval it = list.get(m);
        	if(it.start<newInterval[0])l=m+1;
        	else h=m-1;
        }
        list.add(l,new Interval(newInterval[0], newInterval[1]));
        int i = l-1>=0?l-1:l;
        while(i+1<list.size()) {
        	Interval it1 = list.get(i);
        	Interval it2 = list.get(i+1);
        	if(it2.start<=it1.end) {
        		it1.end = it2.end>=it1.end?it2.end:it1.end;
        		list.remove(i+1);
        	}else {
        		i++;
        	}
        	
        }
        res = new int[list.size()][2];
        for(i=0;i<list.size();i++)
        {
        	res[i][0] = list.get(i).start;
        	res[i][1] = list.get(i).end;
        }
        return res;
    }
}
