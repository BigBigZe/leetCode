package greedy.remove_k_digits;

public class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        StringBuilder sb = new StringBuilder(num);
    	int times=0,p=0;
    	while(times<k) {
    		while(p+1<sb.length()&&
    				sb.charAt(p)<=sb.charAt(p+1)) {
    			p++;
    		}
    		if(p>=sb.length()-1) {
    			sb.deleteCharAt(sb.length()-1);
    			times++;
    			continue;
    		}
    		if(sb.charAt(p)>sb.charAt(p+1)) {
    			sb.deleteCharAt(p);
    			p = p>0?p-1:0;
    		}
    		times++;
    	}
        while(sb.length()>1&&sb.charAt(0)=='0')sb.deleteCharAt(0);
        if(sb.length()==0)return "0";
		return sb.toString();
    }
}
