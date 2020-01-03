package moving_window.longest_substring_without_repeating_characters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if(s==null||s.length()<1)return 0;
        int[]  dict = new int[150];
        char[] cs = s.toCharArray();
        int left = 0,right = 0;
        int max = 0;
        while(right<s.length()) {
        	if(dict[cs[right]]==0) {
        		max = Math.max(max, right-left+1);
        		dict[cs[right]]++;
        		right++;
        	}else {
        		dict[cs[left]] = 0;
        		left++;      		
        	}
        }
    	return max;
    }
    public static void main(String[] args) {
		new Solution().lengthOfLongestSubstring("pwwkew");
	}
}
