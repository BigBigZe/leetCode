package traversal.zigzag_conversion;

public class Optimization {
	public String convert(String s, int numRows) {
		if(numRows<=1||s==null||s.length()<=numRows||s.length()<=2)return s;
		char[] chars = s.toCharArray();
//		s = "";
		StringBuilder result = new StringBuilder();
		int unit = 2*numRows-2;
		for(int i=0;i<numRows;i++) {
			for(int j=i;j<chars.length;j+=unit) {
				result.append(chars[j]);
				if(i==0||i==numRows-1)continue;
				int tmp =j/unit*unit+unit-j%unit;
				if(tmp<chars.length)
					result.append(chars[tmp]);
			}
		}
		return new String(result);
	}
	public static void main(String[] args) {
		new Solution().convert("LEETCODEISHIRING", 4);
		new Optimization().convert("LEETCODEISHIRING", 4);
	}
}
