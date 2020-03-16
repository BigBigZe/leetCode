package sort.reverse_order_pairs;

public class Solution {
    int total = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        for(int i:nums)System.out.print(i+" ");
        return total;
    }

    private void mergeSort(int[] nums,int left,int right){
        if(left>=right)return ;
        int mid = (left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int i = left,j = mid+1,k=0;
        int[] tmp = new int[right+1-left];
        while(i<=mid&&j<=right){
            if(nums[i]<=nums[j])tmp[k++]=nums[i++];
            else{
                total += mid+1-i;
                tmp[k++] = nums[j++];
            }
        }
        while(i<=mid)tmp[k++]=nums[i++];
        while(j<=right)tmp[k++]=nums[j++];
        for(i=left;i<=right;i++)nums[i] = tmp[i-left];
    }
    public static void main(String[] args) {
		int[] nums = {7,5,6,4};
		new Solution().reversePairs(nums);
	}
}
