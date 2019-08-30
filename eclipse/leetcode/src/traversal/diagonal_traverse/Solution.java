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
    		if(direction == 0) {//右上方遍历
    			while(x>=0&&y<n) {
    				res[k++] = matrix[x--][y++];
    			}
    			if(y>=n) {//同时越界，这里只写一个条件是因为y>=n为x<0的充分条件
    				y = n-1;
    				x += 2;
    			}else if(x<0)x=0;
    			direction++;
    		}else {//左下方遍历
    			while(x<m&&y>=0) {
    				res[k++] = matrix[x++][y--];
    			}
    			if(x>=m) {//同时越界
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
