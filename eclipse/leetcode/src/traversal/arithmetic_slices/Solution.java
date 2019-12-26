package traversal.arithmetic_slices;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        if(A==null||A.length<3)return res;
        int diff = A[1]-A[0];
        int length = 2;
        for(int i=2;i<A.length;i++) {
        	if(A[i]-A[i-1]==diff)length++;
        	else {
        		res+= length>=3? (1+length-2)*(length-2)/2:0;
        		length = 2;
        		diff = A[i]-A[i-1];
        	}
        }
        res+= length>=3? (1+length-2)*(length-2)/2:0;
    	return res;
    }
}
