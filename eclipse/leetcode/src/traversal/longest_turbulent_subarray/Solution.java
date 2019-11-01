package traversal.longest_turbulent_subarray;

public class Solution {
    public int maxTurbulenceSize(int[] A) {
    	if(A.length<3)return A.length;
    	int max = 1;
    	int i = 0;

    	while(i<A.length-1) {
        	while(i<A.length-1&&A[i]==A[i+1])i++;//过滤相等的值
        	if(i==A.length-1)return max;
        	int op = A[i]>A[i+1]?0:1; // 记录前一位的比较状态
    		int start = i;
    		while(i<A.length-1) {
    			if(A[i]>A[i+1]&&op%2==0||A[i]<A[i+1]&&op%2==1) {
    				i++;
    				op++;
    			}else break;
    		}
    		max = max>(i-start+1)?max:(i-start+1);
    	}
        return max;
    }
}
