package unionSet.most_stones_removed_with_same_row_or_column;

import java.util.HashSet;
//import java.util.Set;
public class Solution {
	public int removeStones(int[][] stones) {
		UnionSet us = new UnionSet(20000);
		for(int[] stone:stones) 
			us.union(stone[0], stone[1]+1);
		HashSet<Integer> hs = new HashSet<>();
		for(int[] stone:stones)
			hs.add(us.find(stone[0]));
		return stones.length-hs.size();
	}
}
class UnionSet{
	int[] root;
	public UnionSet(int size) {
		root = new int[size];
		for(int i=0;i<size;i++)
			root[i]=i;
	}
	public void union(int p,int q) {
		root[find(p)] = find(q);
	}
	public int find(int q) {
		// TODO Auto-generated method stub
		if(root[q]!=q)
			root[q] = find(root[q]);
		return root[q];
	}
}