package dp.russian_doll_envelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
        int n = envelopes.length,max=1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)dp[i] = 1;
        for(int i=1;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(envelopes[i][0]>envelopes[j][0]&&
        				envelopes[i][1]>envelopes[j][1])
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		max = Math.max(dp[i], max);
        	}
        }
    	return max;
    }
}
