package list.stack.evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens) {
        	if(token.length()==1&&
        			(token.charAt(0)<'0'||token.charAt(0)>'9')) {
        		int former = stack.pop();
        		int latter = stack.pop();
        		int tmp = 0;
        		switch (token.charAt(0)) {
					case '+':
						tmp = former+latter;
						break;
					case '-':
						tmp = latter-former;
						break;
					case '*':
						tmp = latter*former;
						break;
					case '/':
						tmp = latter/former;
						break;
					default :
						break;
				}
        		stack.push(tmp);
        	}else {
        		stack.push(Integer.parseInt(token));
        	}
        }
    	
    	return stack.pop();
    }
    public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		new Solution().evalRPN(tokens);
	}
}
