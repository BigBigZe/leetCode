package hash.isomorphic_strings;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	
    	int[] dict = new int[128];
    	int[] flag = new int[128];
    	for(int i=0;i<s.length();i++) {
    		
    		if(dict[s.charAt(i)]==0&&flag[t.charAt(i)]==1) return false;
    		if(dict[s.charAt(i)]==0){
    			dict[s.charAt(i)] = (int)t.charAt(i);
    			flag[t.charAt(i)] = 1;
    		}
    		
    		if(dict[s.charAt(i)]!=(int)t.charAt(i))return false;
    	}
    	
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().isIsomorphic("ab", "aa"));
	}
}
