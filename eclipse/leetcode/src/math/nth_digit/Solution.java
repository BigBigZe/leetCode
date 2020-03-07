package math.nth_digit;

public class Solution {
    public int findNthDigit(int n) {
        //字典初始化
        if(n<10)return n;
        int[] digits = new int[10];
        int[] start = new int[10];
        digits[1]=9;start[1]=1;
        int shift = 10;
        for(int i=2;i<digits.length;i++){
            int tmp = (Integer.MAX_VALUE-digits[i-1])/(9*i);
            start[i]=shift;
            if(shift>=tmp){
                digits[i]=Integer.MAX_VALUE;
                break;
            }
            digits[i]+=digits[i-1]+9*shift*i;
            shift*=10;
        }  
        
        shift = 1;
        for(;shift<10&&n>digits[shift];shift++);
        int num = (n-digits[shift-1]+1)/shift+start[shift]-1;
        int loc = (n-digits[shift-1])%shift;
        loc = loc==0?shift:loc;
        return String.valueOf(num).charAt(loc-1)-'0'; 
    }
    public static void main(String[] args) {
//    	for(int i=0;i<=40;i++)
    	System.out.print(new Solution().findNthDigit(190)+" ");
		
	}
}
