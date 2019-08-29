package sort.sort_array_by_parity_ii;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i=0,j=A.length-1;
        while(i<A.length||j>0) {
        	while(i<A.length&&(A[i]&1)==0)i+=2;
        	while(j>0&&(A[j]&1)==1)j-=2;
        	if(i<A.length&&j>0) {
        		int tmp = A[i];
        		A[i] = A[j];
        		A[j] = tmp;
        	}
        }
        return A;
     }
}
