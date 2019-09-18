package string.repeated_string_match;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
    	if(A.contains(B))return 1;
    	StringBuilder tmp = new StringBuilder();
    	int i = 1;
    	while(tmp.length()<B.length()*2) {
    		tmp.append(A);
    		if(tmp.toString().contains(B))return i;
    		i++;
    	}
    	return -1;
    }
}
