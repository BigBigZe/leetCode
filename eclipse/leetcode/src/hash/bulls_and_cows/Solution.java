package hash.bulls_and_cows;

public class Solution {
    public String getHint(String secret, String guess) {
    	int[] dict = new int[10];
		char[] sec = secret.toCharArray();
		char[] gus = guess.toCharArray();
		
		int ACounter=0,BCounter=0;
		for(int i = 0;i<gus.length;i++) {
			dict[sec[i]-'0']++;
			if(gus[i]==sec[i]) {
					ACounter++;
		            dict[gus[i]-'0']--;
			}		
		}
		for(int i = 0;i<gus.length;i++) {
			if(gus[i]!=sec[i]&&dict[gus[i]-'0']>0) {
					BCounter++;	
		        dict[gus[i]-'0']--;
			}		
		}

    	
        return ACounter+"A"+BCounter+"B";
    }
}
