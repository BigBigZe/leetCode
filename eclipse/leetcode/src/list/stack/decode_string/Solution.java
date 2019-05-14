package list.stack.decode_string;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
    	if(s==null||s.length()==0)return "";
    	char[] charArray = s.toCharArray();
    	Stack<Integer> nums = new Stack<>();
    	Stack<String> chars = new Stack<>();
    	String num ="";
    	for (char c : charArray) {
			if(c>='0'&&c<='9') {
				num += c;
			}else if(c=='[') {
				nums.push(Integer.parseInt(num));
				num = "";
				chars.push(c+"");
			}else if(c>='a'&&c<='z'||c>='A'&&c<='Z') {
				if(chars.isEmpty()||chars.peek().equals("["))chars.push(c+"");
				else {
					chars.push(chars.pop()+c);
				}
			}else {
				int times = nums.pop();
				String subString = "";
				while(!chars.isEmpty()&&!chars.peek().equals("[")) {
					subString = chars.pop()+subString;
				}
				if(!chars.isEmpty())chars.pop();
				String temp = "";
				for(int i=0;i<times;i++) {
					temp += subString;
				}
				if(chars.isEmpty()||chars.peek().equals("["))chars.push(temp);
				else chars.push(chars.pop()+temp);
			}
		}
    	return chars.pop();
    }
    public static void main(String[] args) {
		System.out.println(new Solution().decodeString("100[leetcode]"));
	}
}
