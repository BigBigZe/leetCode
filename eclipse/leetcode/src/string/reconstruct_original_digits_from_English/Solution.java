package string.reconstruct_original_digits_from_English;

public class Solution {
    public String originalDigits(String s) {
		int[] counter = new int[10];
		int[] dict = new int[26+'a'];
		for(char c:s.toCharArray()) {
			dict[c]++;
		}
		counter[0] = dict['z'];
		counter[2] = dict['w'];
		counter[4] = dict['u'];
		counter[6] = dict['x'];
		counter[8] = dict['g'];
		counter[1] = dict['o']-counter[0]-counter[2]-counter[4];
		counter[3] = dict['h']-counter[8];
		counter[7] = dict['s']-counter[6];
		counter[5] = dict['v']-counter[7];
		counter[9] = dict['i']-counter[5]-counter[6]-counter[8];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<counter.length;i++) {
			for(int j=0;j<counter[i];j++)
				sb.append(i);
		}
		return new String(sb);
	}
}
