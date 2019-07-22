package search.minimum_size_subarray_sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int [] sum = new int[nums.length];
        sum[0] = nums[0];
        int first = Integer.MAX_VALUE;
        if(sum[0]>=s)return 1;
        for(int i =1;i<sum.length;i++) {
        	sum[i] = sum[i-1]+nums[i];
        	if(sum[i]>=s&&i<=first)first = i;
        }
        if(sum[sum.length-1]==s)return sum.length;
        if(sum[sum.length-1]<s)return 0;
        int min = Integer.MAX_VALUE;
        for(int i = first;i<sum.length;i++) {
        	int low = 0, high = i;
        	int target = sum[i]-s;
        	if(target<=sum[0]) {min = min<(i+1)?min:(i+1);
        	continue;
        	}
        	while(low<high) {
        		int mid = (low+high)/2;
        		if(sum[mid]>target) {
        			if(mid==0) {
        				min = min<(i+1-mid)?min:(i+1-mid);
        				break;
        			}else if(sum[mid-1]<=target) {
        				min = min<(i+1-mid)?min:(i+1-mid);
        				break;
        			}else {
        				high = mid-1;
        			}
        		}else if(sum[mid]<target) {
        			if(sum[mid+1]>target) {
        				min = min<(i-mid)?min:(i-mid);
        				break;
        			}else
        				low = mid+1;
        		}else {
        			min = min<(i-mid)?min:(i-mid);
    				break;
        		}
        			
        	}
        }
        
        
    	return min;
    }
    
    //滑动窗口解法
    public int 	minSubArrayLen(int nums[],int s) {		
    	if(nums==null||nums.length==0)return 0;
    	if(nums[0]>=s)return 1;
    	int l = 0, r = 1,min = Integer.MAX_VALUE;
    	int sum  = nums[l]+nums[r];
    	while(l<r&&r<nums.length) {
      		if(nums[r]>=s)return 1;
    		if(sum<s) {
    			if(r<nums.length-1)
    			sum+=nums[++r];
    			//如果min比nums的个数还多，所有元素加起来还是小于s
    			else return min>=nums.length?0:min;
    		}
    		else {
    			min = Math.min(min, r+1-l);
    			sum-=nums[l++];
    		
    		}   		
    	}
    	return min;
    }
    
    public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.println(new Solution().minSubArrayLen( nums,3));;
	}
}
