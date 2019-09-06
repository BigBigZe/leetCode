package sort.largest_number;

public class Solution {
    public String largestNumber(int[] nums) {
	    	String res = "";
	    for(int i=0;i<nums.length;i++) {
	    	int max=nums[i],index=i;
	    	for(int j=i+1;j<nums.length;j++) {
	    		if(max(max,nums[j])!=max) {
	                max = nums[j];
	    			index = j;
	    		}   		
	    	}
	    	res += ""+nums[index];
	    	int tmp = nums[i];
	    	nums[i] = nums[index];
	    	nums[index] = tmp;
	    }
	    int k = 0;
	    while(k<res.length()&&res.charAt(k)=='0')k++;
	    return res.substring(k).length()==0?"0":res.substring(k);
    }

	public int max(int a,int b) {
		String s1 = ""+a,s2=""+b;
		String add1 = s1,add2 = s2;
		while(s1.length()%s2.length()!=0)s1+=add1;
		while(s2.length()%add1.length()!=0)s2+=add2;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s2.charAt(i))continue;
			else return s1.charAt(i)>s2.charAt(i)?a:b;
		}
		return a;
	}
    public static void main(String[] args) {
		int[] nums = {3,30,34,5,9};
		new Solution().largestNumber(nums);
	}
}
