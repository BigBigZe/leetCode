package sort.sort_colors;

public class ClearSolution {
	public void Solution(int[] nums) {
		int i=0,low=0,high=nums.length-1;
		while(i<=high) {
			if(nums[i]==0) {
				nums[i++]=nums[low];
				nums[low++]=0;
			}else if(nums[i]==2) {
				nums[i]=nums[high];//这里i不变因为可能nums[high]==0，仍需要下一步替换
				nums[high--]=2;
				
			}else i++;
		}
	}
}
