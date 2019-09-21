package heap.kth_smallest_element_in_a_sorted_matrix;

public class Optimization {
	public int kthSmallest(int[][] matrix, int k) {
		int min = matrix[0][0],max = matrix[matrix.length-1][matrix.length-1];
		while(min<max) {
			int mid = (min+max)/2;
			int count = counter(matrix,k,mid);
			if(count<k) {
				min = mid+1;
			}else {
				max = mid;
			}
		}
		return 0;
	}

	private int counter(int[][] matrix, int k,int mid) {
		// TODO Auto-generated method stub
		int i=matrix.length-1,j=0;
		int count = 0;
		while(i>=0&&j<matrix.length) {
			if(matrix[i][j]<=mid) {
				count += i;
				j++;
			}else
				i--;
		}
		
		return count;
	}
}
