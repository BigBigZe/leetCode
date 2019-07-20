package search.search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
    	int l = 0,r=matrix.length-1;
    	int last = matrix[0].length-1;
    	
    	while(l<=r) {
    		int mid = (l+r)/2;
    		if(target<matrix[mid][0])
    			r = mid-1;
    		else if(target>matrix[mid][last])
    			l = mid+1;
    		else return binarySearch(matrix[mid], target);
    	}
        return false;
    }

    public boolean binarySearch(int[] array,int target) {
    	int l = 0,r=array.length-1;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		if(target<array[mid])
    			r = mid-1;
    		else if(target>array[mid])
    			l = mid+1;
    		else return true;
    	}
    	return false;
    }
}