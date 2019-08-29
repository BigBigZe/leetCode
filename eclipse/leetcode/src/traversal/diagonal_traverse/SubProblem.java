package traversal.diagonal_traverse;

public class SubProblem {
	public int[] traverse(int[][] nums) {
		int k=0;
		int m = nums.length,n=nums[0].length;
		int[] res = new int[m*n];
		for(int j=0;j<n;j++) {
			int x=0,y=j;
			while(x<m&&y>=0) {
				res[k++] = nums[x++][y--];
			}
		}
		for(int i=1;i<m;i++) {
			int x=i,y=n-1;
			while(x<m&&y>=0) {
				res[k++] = nums[x++][y--];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{22,33,44}};
		int[] traverse = new SubProblem().traverse(nums);
		for(int i:traverse)
			System.out.println(i);
		
	}
	
}
