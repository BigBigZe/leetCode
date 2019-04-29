package list.linkedList.rotate_list;

import java.util.HashMap;
import java.util.Map;

import list.linkedList.ListNode;

public class NewSolution {
    public ListNode rotateRight(ListNode head, int k) {  
        if(head==null||head.next==null)return head;	
        Map<Integer, ListNode> m = new HashMap<>();
        int counter = 1;
        ListNode p = head;
        while(p!=null) {
        	m.put(counter++, p);
        	p = p.next;
        }
        int bias = k%m.size();
        if(bias == 0)return head;
        ListNode opt_pre = m.get(m.size()-bias);
        ListNode opt = opt_pre.next;
        opt_pre.next = null;
        m.get(m.size()).next = head;
        return opt;
    }
}
