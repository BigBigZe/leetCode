package list.linkedList.rotate_list;

import list.linkedList.ListNode;

public class OldSolution {
    public ListNode rotateRight(ListNode head, int k) {
    	  
        if(head==null||head.next==null)return head;
        int length = 1;
        ListNode p = head;
        ListNode tail = null;
        while(p.next!=null) {
        	length ++;
        	p = p.next;
        }
        
        if(k%length==0)return head;
        
        tail = p;
        p = head;
        
         int halt = length-k%length-1;
        while(halt>0) {
        	halt -- ;
        	p = p.next;
        }
        ListNode temp = p.next;
        p.next = null;
        tail.next = head;
        return temp;
    }
}
