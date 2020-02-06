package greedy.non_overlapping_intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public int eraseOverlapIntervals(int[][] intervals) {
    	List<Entry> list = new ArrayList<>();
    	List<Entry> res = new LinkedList<Entry>();
    	for(int[] in:intervals)list.add(new Entry(in));
    	list.sort(new Comparator<Entry>() {

			@Override
			public int compare(Entry o1, Entry o2) {
				// TODO Auto-generated method stub
				if(o1.first==o2.first) {
					if(o1.second==o2.second)return 0;
					if(o1.second<o2.second)return -1;
					else return 1; 
				}
					
				if(o1.first<o2.first)return -1;
				else return 1;
			}
		});
    	
    	res.add(list.get(0));
    	
    	for(int i=1;i<list.size();i++) {
    		Entry tmp = res.get(res.size()-1);
    		Entry current = list.get(i);
    		if(current.first>=tmp.second)res.add(current);
    		else if(current.second<tmp.second) {
    				res.remove(res.size()-1);
    				res.add(current);
    		}
    	}
    	return res.size();
    }
}
class Entry{
	int first,second;
	public Entry(int[] interval) {
		this.first = interval[0];
		this.second = interval[1];
	}
}