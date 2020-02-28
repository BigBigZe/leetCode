package moving_window.minimum_window_substring;

public class Solution {
    public String minWindow(String s, String t) {
    	if(s.length()<t.length())return "";
    	int[] dict_t = new int[127-32];
    	int[] dict_s = new int[127-32];
    	for(char c:t.toCharArray())
    		dict_t[c-' ']++;
    	
    	int left = 0, right=t.length();
    	for(int i=0;i<right;i++)
    		dict_s[s.charAt(i)-' ']++;
    	String res = "";
    	while(left+t.length()<=s.length()&&right<=s.length()) {
    		if(valid(dict_t,dict_s)) {
    			if(res=="")res = s.substring(left, right);
    			else 
    				res = res.length()<s.substring(left, right).length()
    						?res:s.substring(left, right);
    			dict_s[s.charAt(left)-' ']--;
    			left++;
    		}else {
    			if(right<s.length())
    				dict_s[s.charAt(right)-' ']++;
    			right++;
    		}
    	}
    	
    	System.out.println(res);
    	return res;
    }

	private boolean valid(int[] dict_t, int[] dict_s) {
		// TODO Auto-generated method stub
		for(int i=0;i<26;i++) {
			if(dict_t[i]>dict_s[i])
				return false;
		}
		return true;
	}
    public static void main(String[] args) {
//		new Solution().minWindow("ADOBECODEBANC", "AE");
    	System.out.println();
	}
}
