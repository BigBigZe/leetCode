package list.linkedList.merge_k_Sorted_Lists;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import list.linkedList.ListNode;

public class MySolution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length==0)return null;
    	Map<Integer, ListNode> headmap = new HashMap<>();
    	Map<Integer, ListNode> tailmap = new HashMap<>();
    	for (ListNode head : lists) {
			while(head!=null) {
				if(headmap.containsKey(head.val)) {
					ListNode nodeInMap = tailmap.get(head.val);
					nodeInMap.next = head;
					tailmap.put(head.val, head);
				}else {
					headmap.put(head.val, head);
					tailmap.put(head.val, head);
				}
				head = head.next;
			}
		}
    	
    	Set<Integer> set = headmap.keySet();
    	if(set.isEmpty()||lists.length==1)return lists[0];
    	List<Integer> list = new LinkedList<>(set);
    	Collections.sort(list);   	
    	Iterator<Integer> iterator = list.iterator();
    	ListNode res = headmap.get(iterator.next());
    	ListNode head = res;
    	ListNode tail = tailmap.get(head.val);
    	while(iterator.hasNext()) {
    		head = headmap.get(iterator.next());
    		tail.next = head;
    		tail = tailmap.get(head.val);
    	}
        return res;
    }

}
