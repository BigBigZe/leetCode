package hash.sort_characters_by_frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        int[] alphbet = new int[126-32+1];
        for(char c: s.toCharArray()) {
        	alphbet[c-' ']++; //ASCII码中可显示字符从' '开始（第32位） 
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<alphbet.length;i++) {
        	if(alphbet[i]==0)continue;
        	char key = (char) (' '+i);
        	map.put(key, alphbet[i]);
        }
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entrySet);
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1,
					Map.Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue()>o2.getValue())return -1;
				if(o1.getValue()<o2.getValue())return 1;
				return 0;
			}
		});
        for(Map.Entry<Character, Integer> e:list) {
        	for(int i = 0;i<e.getValue();i++)res.append(e.getKey());
        }
    	return res.toString();
    }
    public static void main(String[] args) {
		System.out.println(new Solution().frequencySort("acabacdeddd"));
	}
}
