package dp.stock.iii;

public class Solution {
    public int maxProfit(int[] prices) {
    	int max =0,res=0;
    	int [] asc = new int[prices.length],das = new int[prices.length];
       	if(prices.length<=1)return 0;
    	int min=prices[0];
    	for(int i=0;i<prices.length;i++)
    	{
    		max = Math.max(max, prices[i]-min);
    		asc[i] = max;
    		min = Math.min(min, prices[i]);
    	}
    	res = max;
    	max = prices[prices.length-1];min = 0;
    	for(int i=prices.length-1;i>=0;i--) {
    		min = Math.min(min, prices[i]-max);
    		das[i] = -min;
    		max = Math.max(max, prices[i]);
    	}
    	for(int i=0;i<prices.length;i++)
    		res = Math.max(asc[i]+das[i], res);
        return res;
    }
}
