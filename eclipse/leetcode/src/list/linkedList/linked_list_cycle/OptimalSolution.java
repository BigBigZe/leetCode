package list.linkedList.linked_list_cycle;

import list.linkedList.ListNode;

public class OptimalSolution {
	
    public boolean hasCycle(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast!=null) {
    		if(fast.next==null||fast.next.next==null)return false;
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow)return true;
    	}
        return false;
    }
}
