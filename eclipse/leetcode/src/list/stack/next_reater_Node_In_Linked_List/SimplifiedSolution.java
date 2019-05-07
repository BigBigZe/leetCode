package list.stack.next_reater_Node_In_Linked_List;

import java.util.Stack;

import list.linkedList.ListNode;

public class SimplifiedSolution {
	public int[] nextLargerNodes(ListNode head) {
		int[] array = new int[10000];
		int size=0;
		Stack<Integer> s = new Stack<>();
		while(head!=null) {
			array[size++]=head.val;
			head = head.next;
		}
		int[] res = new int[size];
		for(int i=0;i<size;i++) {
			while(!s.isEmpty()&&array[i]>array[s.peek()]) {
				res[s.pop()] = array[i]; 
			}
			s.push(i);
		}
		return res;
	}
}
