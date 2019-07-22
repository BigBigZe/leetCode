package string.longest_palindrome;


public class Solution {
    public int longestPalindrome(String s) {
    	int[] dict = new int['z'-'A'+1];
    	for(char c:s.toCharArray()) {
    		dict[c-'A']++;
    	}
    	int counter=0;
    	boolean flag = false;
    	for(int i = 0;i<dict.length;i++) {
    		if((dict[i]&1)==1) {
    			flag = true;
    			counter += dict[i]-1;
    		}else
    			counter += dict[i];
    	}
    	return flag==true?counter+1:counter;
    }
}
