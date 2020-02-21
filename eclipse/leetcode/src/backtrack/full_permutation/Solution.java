package backtrack.full_permutation;

import java.util.LinkedList;
import java.util.List;
//带重复元素的全排列
public class Solution {
	int [] a = {2,2,3,3};
	int [] visited = new int[4];
	
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	
	void list(List<Integer> l,int k) {
		if(k>a.length)return;
		if(visited[0]==0) {
			visited[0]=1;
			l.add(a[0]);
			list(l,k+1);
			if(k==a.length) {
				List<Integer> tmp = new LinkedList<Integer>(l);
				res.add(tmp);
			}
			l.remove(l.size()-1);
			visited[0]=0;
		}
		for(int i=1;i<visited.length;i++) {
			if(a[i]==a[i-1]&&visited[i-1]==0)continue;
			if(visited[i]==0) {
				visited[i]=1;
				l.add(a[i]);
				list(l,k+1);
				if(k==a.length) {
					List<Integer> tmp = new LinkedList<Integer>(l);
					res.add(tmp);
				}
				l.remove(l.size()-1);
				visited[i]=0;
			}
			
		}
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		s.list(new LinkedList<Integer>(), 1);
		for(List<Integer> re:s.res) {
			for(int i:re)
				System.out.print(i);
			System.out.println();
		}
	}
}
