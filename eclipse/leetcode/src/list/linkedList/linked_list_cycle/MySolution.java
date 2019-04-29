package list.linkedList.linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

import list.linkedList.ListNode;

public class MySolution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        while(head!=null) {
        	if(s.contains(head))return true;
        	s.add(head);
        	head = head.next;
        }
        return false;
    }
}
