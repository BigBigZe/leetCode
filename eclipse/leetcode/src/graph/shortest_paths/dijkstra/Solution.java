package graph.shortest_paths.dijkstra;

public class Solution {
	public int[] dijkstra(int[][] matrix,int start) {
		int[] distance = new int[matrix.length];
		int[] visited = new int[distance.length];
		visited[start] = 1;
		//初始化
		for(int i=0;i<distance.length;i++)
			distance[i] = matrix[start][i];
		
		for(int i=1;i<distance.length;i++) {
			
			int current=start, min=999;
			//找出当前离start最近的点
			for(int j=0;j<distance.length;j++) {
				if(visited[j]==1)continue;
				if(min>distance[j]) {
					min = distance[j];
					current=j;
				}
			}
			//更新路径
			visited[current]=1;
			for(int j=0;j<distance.length;j++) {
				if(visited[j]==0) {
					distance[j] = Math.min(distance[j], 
							distance[current]+matrix[current][j]);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) {
		int[][] m = {{0,7,9,11,999,999},
					{7,0,8,999,999,20},
					{9,8,0,999,6,999},
					{11,999,999,0,3,999},
					{999,999,6,3,0,1},
					{999,20,999,999,1,0}};
		for(int i:new Solution().dijkstra(m, 0)) {
			System.out.print(i+" ");
		}
	}
}
