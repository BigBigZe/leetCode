package sort.largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Optimization {
	public String largestNumber(int[] nums) {
		String[] s = new String[nums.length];
		for(int i=0;i<nums.length;i++)
			s[i] = String.valueOf(nums[i]);
		Arrays.sort(s,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s2.compareTo(s1);
			}
		});
		
		StringBuilder res = new StringBuilder();
		for(String ss:s)
			res.append(ss);
		if(res.charAt(0)=='0')return "0";
		
		return res.toString();
	}
}
