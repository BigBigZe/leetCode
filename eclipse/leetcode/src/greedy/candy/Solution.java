package greedy.candy;

public class Solution {
    public int candy(int[] ratings) {
    	if(ratings.length==1)return 1;
		int sum = 0;
		for(int i=0;i<ratings.length;i++) {
			int pos = i;
			int left = 1,right=1;
			while(pos>0&&ratings[pos]>ratings[pos-1]) {
				left++;
				pos--;
			}
			pos = i;
			while(pos<ratings.length-1&&ratings[pos]>ratings[pos+1]) {
				right++;
				pos++;
			}
			sum+=Math.max(left, right);
		}
		
		return sum;
    }
    
    public static void main(String[] args) {
		int[] ratings = {1,2,3,1,0};
		System.out.println(new Solution().candy(ratings));
	}
}
