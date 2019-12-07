package unionSet.satisfiability_of_equality_equations;

public class Solution {
    public boolean equationsPossible(String[] equations) {
    	UF uf = new UF();
    	for(String equation:equations) 
    		if(equation.charAt(1)=='=') 
    			uf.unionEqual(equation.charAt(0)-'a', equation.charAt(3)-'a');
    	for(String differ: equations)
    		if(differ.charAt(1)=='!'&&
    				uf.findEqual(differ.charAt(0)-'a')==
    				uf.findEqual(differ.charAt(3)-'a'))
    			return false;   		
        return true;
    }	
    public static void main(String[] args) {
		String[] equations= {"a==b","a!=b"};
		new Solution().equationsPossible(equations);
	}
}
class UF{
	int[] equal = new int[26];
	UF() {
		for(int i=0;i<26;i++) 
			equal[i]=i;
	}
	void unionEqual(int p,int q) {
		equal[findEqual(p)] = findEqual(q);
	}
	int findEqual(int q) {
		// TODO Auto-generated method stub
		if(equal[q]!=q)
			equal[q] = findEqual(equal[q]);		
		return equal[q];
	}
}