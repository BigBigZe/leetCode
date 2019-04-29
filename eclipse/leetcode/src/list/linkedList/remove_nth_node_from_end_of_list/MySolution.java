package list.linkedList.remove_nth_node_from_end_of_list;

import java.util.HashMap;
import java.util.Map;

import list.linkedList.ListNode;

public class MySolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head==null||head.next==null)return null;
    	Map<Integer, ListNode> m = new HashMap<>();
    	ListNode p = new ListNode(-1);
    	p.next = head;
    	head = p;
    	int i = 1;
    	while(p!=null) {
    		m.put(i, p);
    		p = p.next;
    		i++;
    	}	 
    	p = m.get(m.size()-n);
    	p.next = p.next.next;
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
