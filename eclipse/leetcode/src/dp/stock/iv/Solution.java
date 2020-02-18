package dp.stock.iv;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int max = 0,n = prices.length;
        if(prices.length<=1)return 0;
        if(k>n/2)k=n/2;
        int [][] oneTime = new int[n][n];
        int [][] KTime = new int[n][2];
        for(int i=0;i<n;i++) {
        	int tmp = 0,min = prices[i];
        	for(int j=i;j<n;j++) {
        		tmp = Math.max(prices[j]-min, tmp);
        		oneTime[i][j] = tmp;
        		min = Math.min(min, prices[j]);
        	}
        	max = Math.max(max, tmp);
        }
        for(int i=0;i<n;i++)KTime[i][0] = oneTime[0][i];
        for(int j=2;j<=k;j++) {
        	for(int i=0;i<n;i++) {
        		if(i/2<j) {
        			KTime[i][1] = KTime[i][0];
        			continue;
        		}
        		KTime[i][1] = Math.max(KTime[i][0], 0);
        		for(int l=0;l<i;l++)
        			KTime[i][1] = 
        			Math.max(KTime[i][1], KTime[l][0]+oneTime[l+1][i]);
        		max = Math.max(KTime[i][1], max);
        		for(int l=0;l<n;l++)
        			KTime[l][0] = KTime[l][1];
        	}
        }
        
        
    	return max;
    }
    public static void main(String[] args) {
		int[] prices = {2,4,1};
		new Solution().maxProfit(2, prices);
	}
}
