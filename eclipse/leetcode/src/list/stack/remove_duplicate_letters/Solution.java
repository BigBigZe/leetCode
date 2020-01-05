package list.stack.remove_duplicate_letters;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
    	if(s.length()<=1)return s;
        int[] dict = new int[26];
        int[] exist = new int[26];
        char[] cs = s.toCharArray();
        for(char c: cs)dict[c-'a']++;
        Stack<Character> stack = new Stack<>();
        stack.add(cs[0]);
        exist[cs[0]-'a'] = 1;
        
        for(char c:cs) {
        	dict[c-'a']--;
    		if(exist[c-'a']!=0)continue;
    		while(!stack.isEmpty()&&c<=stack.peek()&&dict[stack.peek()-'a']!=0) {
    			exist[stack.pop()-'a']=0;
    		}
    		stack.push(c);
            exist[c-'a'] = 1;
        }
        
        char[] res = new char[stack.size()];
        for(int i = 0; i < stack.size(); i++)
            res[i] = stack.get(i);
        return new String(res);
    }
   public static void main(String[] args) {
	   System.out.println(new Solution().removeDuplicateLetters("saqwaquwhq"));
//	   System.out.println("abc".compareTo("acd"));
   }
    
}
