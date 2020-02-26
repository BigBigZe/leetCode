package bit.power_of_four;
/**
 * 判断4的幂
 * @author zone
 *
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0)return false;
        int counter = 0;
        while(num!=0) {
        	if((num&1)==1) {
        		if(num>1)return false;
        		else break;
        	}	
        	counter++;
        	num = num>>1;
        }
        return counter%2==0;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfFour(64));
	}
}
