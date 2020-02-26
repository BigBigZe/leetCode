package dfs.keys_and_rooms;

import java.util.List;

public class Solution {
	int counter = 0;
	
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] open = new int[rooms.size()];
		open[0] = 1;
		return visit(rooms,open,0);    	
    }

	private boolean visit(List<List<Integer>> rooms, int[] open,int room) {
		// TODO Auto-generated method stub
		for(int i:rooms.get(room)) {
			if(open[i]==1)continue;
			if(open[i]==0) {
				open[i]=1;
				counter++;
				visit(rooms,open,i);
			}
		}
		return counter==open.length;
	}
}
