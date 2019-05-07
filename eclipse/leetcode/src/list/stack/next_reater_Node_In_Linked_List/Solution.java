package list.stack.next_reater_Node_In_Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import list.linkedList.ListNode;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
    	ListNode p = head;
    	
    	//这里不用LinkedList，因为后面有很多访问操作
    	List<Integer> list = new ArrayList<>();
    	
    	while(p!=null) {
    		list.add(p.val);
    		p = p.next;
    	}
    	int[] res = new int[list.size()];
    	Stack<Integer> s = new Stack<>();
    	for(int i=0;i<list.size();i++) {
    		int exNum = list.get(i);
			while(!s.isEmpty()&&exNum>list.get(s.peek())) {
				int index = s.pop();
				res[index] = exNum;
			}
			s.push(i);
    
    	}
//    	while(!s.isEmpty())res[s.pop()]=0;
//    	这里不用做清空栈的操作，因为初始化时全为0
        return res;
    }
}
