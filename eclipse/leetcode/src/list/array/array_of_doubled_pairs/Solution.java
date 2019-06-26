package list.array.array_of_doubled_pairs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Solution {
	public boolean canReorderDoubled(int[] A) {
		Vector<Integer> posList = new Vector<>();
		Vector<Integer> negList = new Vector<>();
		for(int i:A)
			if(i>=0)posList.add(i);
			else negList.add(i);
		Collections.sort(negList);
		Collections.sort(posList);
		int size = posList.size()/2;
		for(int i = 0;i<size;i++) {
			if(!posList.remove(Integer.valueOf(posList.get(i)*2)))
				return false;	
		}
		size = negList.size()/2;
		for(int i = 0;i<size;i++) {
			if(!negList.remove(Integer.valueOf(negList.get(i)/2)))
				return false;	
		}
		return true  ;
	}
}
