package unionSet.smallest_string_with_swaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		l1.add(0);l1.add(3);
		List<Integer> l2 = new LinkedList<>();
		l2.add(1);l2.add(2);
		List<List<Integer>> pairs = new LinkedList<>();
		pairs.add(l1);
		pairs.add(l2);
		new Solution().smallestStringWithSwaps("dcab", pairs);
	}
    public String smallestStringWithSwaps(String s, 
    		List<List<Integer>> pairs) {
    	UF uf = new UF(s.length());
    	char[] sc = s.toCharArray();
        for(List<Integer> pair:pairs) 
        	uf.union(pair.get(0), pair.get(1));
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> cmap = new HashMap<>();
        for(int i=0;i<uf.root.length;i++) {
        	int r = uf.find(i);
        	if(map.containsKey(r)) {
        		map.get(r).add(i);
        		cmap.get(r).add(sc[i]);
        	}else {
        		ArrayList<Integer> list = new ArrayList<>();
        		list.add(i);
        		map.put(r, list);
        		ArrayList<Character> clist = new ArrayList<>();
        		clist.add(sc[i]);
        		cmap.put(r, clist);
        	}		
        }
        for(Integer key:map.keySet()) {
        	ArrayList<Integer> ilist = map.get(key);
        	ArrayList<Character> clist = cmap.get(key);
        	Collections.sort(ilist);
        	Collections.sort(clist);
        	for(int i=0;i<ilist.size();i++)
        		sc[ilist.get(i)] = clist.get(i);
        }
    	return new String(sc);
    }
}
class UF{
	int[] root;
	public UF(int size) {
		this.root = new int[size];
		for(int i=0;i<size;i++)
			root[i] = i;
	}
	public void union(int p, int q) {
		root[find(p)] = find(q);
	}
	public int find(int p) {
		if(root[p]!=p)
			root[p] = find(root[p]);
		return root[p];
	}
}