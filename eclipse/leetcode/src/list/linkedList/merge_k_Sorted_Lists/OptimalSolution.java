package list.linkedList.merge_k_Sorted_Lists;

import list.linkedList.ListNode;

public class OptimalSolution {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0)return null;
		if(lists.length==1)return lists[0];
		if(lists.length==2)return mergeTwoLists(lists[0], lists[1]);
		
		int mid = lists.length/2;
		
		ListNode[] lists1 = new ListNode[mid];
		for(int i=0;i<mid;i++) {
			lists1[i] = lists[i];
		}
		ListNode[] lists2 = new ListNode[mid];
		for(int i=mid;i<lists.length;i++) {
			lists2[i] = lists[i];
		}
		return mergeTwoLists(mergeKLists(lists1),mergeKLists(lists2));
	}
	public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		if(l1==null)return l2;
		if(l2==null)return l1;
		
		ListNode head = null;
		if(l1.val<=l2.val) {
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
		}else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}
		
		return head;
	}
}
