package dp.minimum_falling_path_sum;

public class Solution {
    public int minFallingPathSum(int[][] A) {
    	if(A[0].length==1) {
    		int sum = 0;
    		for(int[] d:A)
    			sum+=d[0];
    		return sum;
    	}
    	
    	int[][] record = new int [A.length][A[0].length];
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<A[0].length;i++) {
    		record[0][i] = A[0][i];
    	}
    	
    	
    	for(int i=1;i<record.length;i++) {
    		
    		record[i][0] = Math.min(record[i-1][0], record[i-1][1])+A[i][0];
    		for(int j=1;j<record[i].length-1;j++) {
    			record[i][j] = 
    					Math.min(Math.min(record[i-1][j-1], 
    							record[i-1][j]), record[i-1][j+1])+A[i][j];
    		}
    		record[i][record[i].length-1] = Math.min(record[i-1][record[i].length-1], 
    				record[i-1][record[i].length-2])+A[i][0];
    	}
    	
    	for(int path:A[A.length-1])
    		min = Math.min(min, path);
    	
        return min;
    }
}
