package search.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int l = 0,r = nums.length-1;
    	int[] res = new int[2];
    	res[0] = findL(nums, target, l, r);
    	res[1] = findR(nums, target, l, r);
        return res;
    }
    public int findR(int[] nums,int target,int l,int r) {
    	int res = -1;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		if(nums[mid]<target)l=mid+1;
    		else if(nums[mid]>target)r=mid-1;
    		else {
    			int temp = findR(nums, target, mid+1,r );
    			res = temp==-1?mid:temp;
    			break;
    		}
    	}
    	return res;
    }
    public int findL(int[] nums,int target,int l,int r) {
    	int res = -1;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		if(nums[mid]<target)l=mid+1;
    		else if(nums[mid]>target)r=mid-1;
    		else {
    			int temp = findL(nums, target, l,mid-1 );
    			res = temp==-1?mid:temp;
    			break;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
    	
		int[] nums = {5,7,7,8,8,10};
		System.out.println(new Solution().findR(nums, 8, 0, 5));
	}
}
