package list.linkedList.add_Two_Numbers;

import list.linkedList.ListNode;
/**
 * can't understand what the f**king code want to say
 * */
public class OriginalSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int shift = 0;
    	ListNode p = l1,last = l1;
    	while(l1!=null||l2!=null) {
    		int sum = 0;
    		if(p!=null&&l2!=null) {
    			if((p.val+l2.val+shift)/10!=0) {
    				sum = p.val+l2.val+shift-10;
    				shift = 1;
    			}else {
    				sum = p.val+l2.val+shift;
    				shift = 0;
    			}
    			p.val = sum;
    			last = p;
    			p = p.next;
    			l2 = l2.next;
    		}else if(p==null&&l2!=null) {
    			if((l2.val+shift)/10!=0) {
    				sum = l2.val + shift-10;
    				shift = 1;
    			}else {
    				sum = l2.val+shift;
    				shift = 0;
    			}
    			last.next = new ListNode(sum);
    			last = last.next;
    			p = last.next;
    			l2 = l2.next;
    		}else if(p==null&&l2==null){
    			if(shift==1)last.next = new ListNode(1);
    			break;
    		}else {
    			if((p.val+shift)/10!=0) {
    				sum = p.val + shift-10;
    				shift = 1;
    			}else {
    				sum = p.val+shift;
    				shift = 0;
    			}
    			p.val = sum;
    			last = p;
    			p = p.next;
    		}
    	}
        return l1;
    }

}
