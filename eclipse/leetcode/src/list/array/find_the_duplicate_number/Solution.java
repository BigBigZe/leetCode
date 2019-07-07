package list.array.find_the_duplicate_number;

public class Solution {
    public int MYfindDuplicate(int[] nums) {
        int fast = 1;
        int slow = 0;
        while(!(nums[fast%nums.length]==nums[slow%nums.length]&&
             fast%nums.length!=slow%nums.length)){
            slow++;
            fast+=2;
        }
        return nums[slow%nums.length];
    }
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        while(true) {
        	slow = nums[slow];
        	fast = nums[fast];
        	fast = nums[fast];
        	if(fast==slow)break;
        }
        fast = 0;
        while(slow!=fast) {
        	slow = nums[slow];
        	fast = nums[fast];
        }
        return slow;
    }
}
