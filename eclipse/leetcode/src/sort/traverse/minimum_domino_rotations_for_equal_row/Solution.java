package sort.traverse.minimum_domino_rotations_for_equal_row;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
    	int[] A1 = new int[7];
    	int[] B1 = new int[7];
    	for(int i=0;i<A.length;i++)
    	{
    		A1[A[i]]++;
    		B1[B[i]]++;
    	}
    	int a= 0;
    	for(int i=1;i<A1.length;i++)
    		if(A1[i]+B1[i]>=A.length)a=i;
    	if(a==0)return -1;
    	int counterA = 0,counterB=0;
    	for(int i=0;i<A.length;i++) {
    		if(A[i]!=a&&B[i]!=a)return -1;
    		if(A[i]!=a)counterA++;
    		if(B[i]!=a)counterB++;
    	}
    	return counterA>counterB?counterB:counterA;
    }
}
