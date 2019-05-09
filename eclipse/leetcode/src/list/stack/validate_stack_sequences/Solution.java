package list.stack.validate_stack_sequences;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int pop : popped) {
			for(;i<pushed.length;i++) {
				if(!s.isEmpty()&&s.peek()==pop) {
					s.pop();
					break;
				}
				else
					s.push(pushed[i]);
			}
			if(!s.isEmpty()&&s.peek()==pop)
				s.pop();	
		}
        if(s.isEmpty())
        return true;
        else return false;
    }
}
