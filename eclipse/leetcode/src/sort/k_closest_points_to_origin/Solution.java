package sort.k_closest_points_to_origin;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
    	quickSort(0,points.length-1,points,K);
    	int[][] res = new int[K][2];
    	for(int i=0;i<K;i++)
    		res[i] = points[i];
    	return res;
    }

	private void quickSort(int left, int right, int[][] points, int k) {
		// TODO Auto-generated method stub
		if(left>=right)return;
		int i=left,j = right;
		int[] pivot = {points[left][0],points[left][1]};
		while(i<j) {
			while(i<j&&dis(points[j])>=dis(pivot))j--;
			if(i<j)points[i++] = points[j];
			while(i<j&&dis(points[i])<dis(pivot))i++;
			if(i<j)points[j--] = points[i];
		}
		points[i] = pivot;
		
		quickSort(left, i-1, points, k);
		if(i>=k)return;
		quickSort(i+1, right, points, k);	
		return ;
	}
	private int dis(int[] point) {
		return point[0]*point[0]+point[1]*point[1];
	}

}
