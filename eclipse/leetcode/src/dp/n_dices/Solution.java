package dp.n_dices;

public class Solution {
    public double[] twoSum(int n) {
    	double[] res = new double[n*5+1];
    	double[][] dp = new double[n+1][6*n+1];
    	for(int i=1;i<=6;i++)dp[1][i]=1.0/6;
    	for(int i=2;i<=n;i++)
    		for(int j=i;j<=i*6;j++) {
    			for(int k=1;k<=6;k++) {
    				if(j-k<=0)break;
    				dp[i][j] += dp[i-1][j-k]*1.0/6;
    			}
    		}
    	int k=0;
    	for(int i=n;i<=6*n;i++)
    		res[k++] = dp[n][i];
    	
    	return res;
    }
    public static void main(String[] args) {
		new Solution().twoSum(1);
	}
}
