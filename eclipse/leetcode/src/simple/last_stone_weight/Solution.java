package simple.last_stone_weight;

import java.util.Arrays;

public class Solution {
    public int lastStoneWeight(int[] stones) {
    	if(stones.length<=1)return stones[0];
    	Arrays.sort(stones);	
    	for(int i = stones.length-2;i>=0;i--) {
    		stones[i]= Math.abs(stones[i]-stones[i+1]);
    		stones[i+1] = 0;
    		//二分插入
    		if(i==0)return stones[0];
    		insert(stones,0,i);
    	}
        return 0;
    }
    private void insert(int[] stones, int i, int j) {
		// TODO Auto-generated method stub
    	int l=i,h=j-1,m=0,x = stones[j];
    	while(l<=h) {
    		m = (l+h)/2;
    		if(stones[m]==x) {
    			l = m;
    			break;
    		}
    		if(stones[m]>x)
    			h = m-1;
    		else l = m+1;
    	}
    	while(j>l) {
    		stones[j]=stones[j-1];
    		j--;
    	}
    	stones[l] = x;
	}
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		new Solution().lastStoneWeight(stones);
	}
}
