package graph.course_schedule;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] map = new int[numCourses][numCourses];
        for(int[] i:prerequisites) {
        	int end=i[0],start=i[1];
        	map[start][end]=1;
        	degree[end]++;
        }
        List<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++) {
        	if(degree[i]==0)queue.add(i);
        }
        if(queue.size()==0)return false;
        while(queue.size()!=0) {
        	int start = queue.remove(0);
        	for(int i=0;i<numCourses;i++) {
        		if(map[start][i]!=0) {
        			degree[i]--;
        			if(degree[i]==0)
        				queue.add(i);
        		}	
        	}
        }
        for(int i:degree)if(i!=0)return false;
        return true;
    }
    public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{2,0}};
		new Solution().canFinish(3, prerequisites);
	}
}
