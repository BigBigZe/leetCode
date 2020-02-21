package backtrack.letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<String> res = new LinkedList<String>();
	char[] start = {' ',' ','a','d','g','j','m'
			,'p','t','w','z'+1};
    public List<String> letterCombinations(String digits) {
    	if(digits==null||digits.length()==0)return res;
        char[] nums = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(nums,0,sb);
    	return res;
    }
	private void dfs(char[] nums,int level,StringBuilder sb) {
		// TODO Auto-generated method stub
		if(level==nums.length) {
			res.add(new String(sb));
			return;
		}
		int num = nums[level]-'0';
		for(char c=start[num];c<start[num+1];c++) {
			sb.append(c);
			dfs(nums,level+1,sb);
			sb.deleteCharAt(sb.length()-1);
		}	
		
	}
	
}
