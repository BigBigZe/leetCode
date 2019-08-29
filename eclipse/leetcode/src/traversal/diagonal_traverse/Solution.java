package traversal.diagonal_traverse;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int[] res={} ;
        if(matrix==null)return null;
        if(matrix.length==0)return res;
    	int m = matrix.length,n = matrix[0].length;
    	res = new int[m*n];
    	int direction = 0,x=0,y=0,k=0;
    	while(k<res.length){
    		if(direction == 0) {
    			while(x>=0&&y<n) {
    				res[k++] = matrix[x--][y++];
    			}
    			if(y>=n) {
    				y = n-1;
    				x += 2;
    			}else if(x<0)x=0;
    			direction++;
    		}else {
    			while(x<m&&y>=0) {
    				res[k++] = matrix[x++][y--];
    			}
    			if(x>=m) {
    				x = m-1;
    				y += 2;
    			}else if(y<0)
    				y=0;
    			direction--;
    		}
    	}
    	return res;
    }
    
    
}
