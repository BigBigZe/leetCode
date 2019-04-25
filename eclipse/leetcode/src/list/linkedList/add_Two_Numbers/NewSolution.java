package list.linkedList.add_Two_Numbers;

import list.linkedList.ListNode;

public class NewSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode res = new ListNode(0);
    	ListNode p = res;				//操作的指针
    	int shift = 0;					//进位
    	while(l1!=null||l2!=null) {
    		int val1 = l1==null?0:l1.val;
    		int val2 = l2==null?0:l2.val;
    		int sum = val1+val2+shift;
    		shift = sum>=10?1:0;
    		p.next = new ListNode(sum%10);
    		p = p.next;
    		l1 = l1==null?l1:l1.next;
    		l2 = l2==null?l2:l2.next;
    	}
    	if(shift == 1)p.next = new ListNode(1);
        return res.next;
    }
}
