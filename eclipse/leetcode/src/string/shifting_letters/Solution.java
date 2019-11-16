package string.shifting_letters;

public class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] array = S.toCharArray();
//        StringBuilder sb = new StringBuilder();
        int times = 0;
        for(int i=array.length-1;i>=0;i--) {       	
        	times = (times+shifts[i]%26)%26;
        	int diff = (array[i]-'a'+times)%26;
        	array[i]=(char)(diff+'a');
        }
        return new String(array);
    }
}
