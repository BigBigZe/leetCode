package list.stack.trapping_rain_water;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        if(height==null||height.length<=2)return 0;
        int[] table = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        table[0] = height[0];
        int maxIndex = 0 , max=height[0];
        for(int i = 1;i<height.length;i++) {
        	table[i] = table[i-1]+height[i];
        	if(height[i]==0)continue;
        	int top = stack.peek();
        	if(height[i]<=height[top]) {
        		stack.push(i);continue;
        	}
        	if(height[i]>max) {
        		sum -= table[i-1]-table[maxIndex];
        		sum+=max*(i-maxIndex-1);
        		maxIndex = i;
        		max = height[i];        		
        	}
        	while(!stack.isEmpty()) {
        		if(height[i]>height[stack.peek()])
        			stack.pop();
        		else break;
        	}       	
        	stack.push(i);
        }
        
        if(stack.size()>1) {
        	int bottom = stack.pop();
        	while(!stack.isEmpty()) {
        		int top = stack.pop();
        		sum-=table[bottom-1]-table[top];
        		sum+=(bottom-top-1)*height[bottom];
        		bottom = top;
        	}
        }
		return sum ;
    }
}
