package list.array.maximum_swap;

public class Solution {
	   public int maximumSwap(int num) {
		   	if(num<=10)return num;
		   	char[]  nums = (num+"").toCharArray();
	    	char maxNum='0';
	        int maxIndex=nums.length-1;
	        //从后往前找到需要换的最大的数
	    	for(int i=nums.length-1;i>0;i--) {
	    		if(nums[i]<nums[i-1]&&i!=1)continue;
	            if(nums[i]>maxNum) {
	            	int j=i;
	            	while(j>0) {
	            		if(nums[j]<=nums[j-1])
	            			j--;
	            		else {
	            			maxNum = nums[i];
		    				maxIndex = i;
		    				break;
	            		}
	            			
	            	}
	            	
	            	if(j>0) {
	            		maxNum = nums[i];
	    				maxIndex = i;
	            	}
	    		}
	    		if(maxNum=='9')break;
	    	}
	    	for(int i=0;i<maxIndex;i++) {
	    		if(nums[i]<maxNum) {
	    			char temp = nums[i];
	    			nums[i] = nums[maxIndex];
	    			nums[maxIndex] = temp;
	                break;
	    		}
	    	}
	    	return Integer.parseInt(new String(nums));
	    }
    public static void main(String[] args) {
		System.out.println(new Solution().maximumSwap(98004365));;
	}
}
