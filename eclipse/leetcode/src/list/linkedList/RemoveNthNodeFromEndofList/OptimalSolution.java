package list.linkedList.RemoveNthNodeFromEndofList;

import list.linkedList.ListNode;

public class OptimalSolution {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 快慢指针法：f指针和s指针始终会相差n个节点，即如果f到了尾部，
         * s将会处在倒数第n+1处；而n+1可能大于总的节点数，因此需要进行
         * 非空判断。
         * */
        ListNode slow = head, fast = head;
        while (n > 0) {
            fast = fast.next;
            n -= 1;
        }
        if (fast == null) {
            head = head.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }

        return head;
    }
}
