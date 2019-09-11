package list.linkedList.reverse_nodes_in_k_group;

import java.util.ArrayList;
import java.util.List;

import list.linkedList.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;// check null
    	List<ListNode> list = new ArrayList<ListNode>();
    	int counter = 0;
    	ListNode p = head;//movement
    	ListNode start = null;//the head of the subList reversed
    	while(p!=null) { 
    		if(counter%k==0)start = p;// arrive at the start of next group
    		if((counter+1)%k==0) {// arrive at the end of next group
    			ListNode tmp = p.next;
    			p.next = null;
    			list.add(reverse(start));
    			p=tmp;
    			counter++;
    			continue;
    		}
    		
    		counter++;
    		p = p.next;    		
    	}
    	// if the length of remained sublist<k,then add it directly
        if(counter%k!=0)list.add(start);
    	ListNode lastT = list.get(0);
    	while(lastT.next!=null) {
    		lastT = lastT.next;
    	}
    	// connect
    	for(int i=1;i<list.size();i++) {
    		ListNode currentH = list.get(i);
    		lastT.next = currentH;
    		while(currentH.next!=null)currentH = currentH.next;
    		lastT = currentH;
    	}
    	return list.get(0);
    }
    
    //reverse the sub list
    private ListNode reverse(ListNode head) {
        ListNode p = head;
        if(head==null)return head;
        ListNode q = p.next;
        p.next = null;
        while(q!=null) {
        	ListNode tmp = q.next;
        	q.next = p;
        	p = q;
        	q = tmp;
        }
    	return p;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode node = new Solution().reverseKGroup(head, 2);
		while(node!=null)
		{
			System.out.println(node.val);
			node = node.next;

		}
	}
}
