package traversal.longest_mountain_in_array;

public class Solution {
    public int longestMountain(int[] A) {
        if(A.length<3)return 0;
        int i=0,max=0;
        while(i<A.length-1) {
        	while(i<A.length-1&&A[i]>=A[i+1])i++;//去除平地和下坡
        	int start = i;
        	while(i<A.length-1&&A[i]<A[i+1])i++;//从上坡开始  
        	//如果能进入下坡阶段
        	if(i<A.length-1&&A[i]>A[i+1]) {
        		while(i<A.length-1&&A[i]>A[i+1])i++;
            	max = max>(i-start+1)?max:(i-start+1);
        	}else {//不能进入下坡（还是为平地）
        		while(i<A.length-1&&A[i]>=A[i+1])i++;
        	}
        	
        }
        return max;
    }
    
    public static void main(String[] args) {
		int[] A = {0,1,2,3,4,5,4,3,2,1,0};
		System.out.println(new Solution().longestMountain(A));
	}
}
