package bit.single_number_iii;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int tmp = 0;
        for(int i:nums)tmp^=i;
        int mask = tmp^(-tmp);
        for(int i:nums)if((mask&i)>0)res[0]^=i;
        res[1] = tmp^res[0];
        return res;
    }
}
