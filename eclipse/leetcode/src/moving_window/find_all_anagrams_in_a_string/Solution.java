package moving_window.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
		if(s.length()<p.length())return list;
		int[] dict = new int[26];
		Set<Character> set = new HashSet<>();
		for(char c:p.toCharArray())
		{
			dict[c-'a']++;
			set.add(c);
		}       
		//构造窗口
		int left = 0;
		int[] tmp = new int[26];
		for(int i=0;i<p.length();i++) 
			tmp[s.charAt(i)-'a']++;
		while(left-1<s.length()-p.length()) {
			boolean b=true;
			for(char c:set)if(dict[c-'a']!=tmp[c-'a'])b=false;
			if(b)list.add(left);
		    tmp[s.charAt(left)-'a']--;
			left++;
			if(left-1<s.length()-p.length())
				tmp[s.charAt(left+p.length()-1)-'a']++;
		}   
		return list;
    }
}
