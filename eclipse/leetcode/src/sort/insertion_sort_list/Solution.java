package sort.insertion_sort_list;

import list.linkedList.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode patch = new ListNode(-1);
        patch.next = head;
        for(ListNode end=head;end.next!=null;end=end.next) {
        	ListNode pretmp = end;
        	ListNode tmp = end.next;
        	for(ListNode p = patch;p!=end;p=p.next) {
        		if(p.next.val>=tmp.val) {
        			pretmp.next = tmp.next;
        			tmp.next = p.next;
        			p.next = tmp;
        			break;
        		}
        	}
        }
        
    	
    	return patch.next;
    }
    
    public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);
		new Solution().insertionSortList(node);
	}
}
