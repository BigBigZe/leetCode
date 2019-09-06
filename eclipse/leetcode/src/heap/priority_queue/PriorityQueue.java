package heap.priority_queue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
	
	private List<Integer> queue = new ArrayList<Integer>();
	

	public void enqueue(int element) {	
		int l=0,h=queue.size()-1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(queue.get(mid)>=element)h=mid-1;
			if(queue.get(mid)<element)l=mid+1;

		}
		queue.add(l,element);
	
	}
	
	public int dequeue() {
		int res = queue.get(0);
		queue.remove(0);
		return res;
	}
	
	public static void main(String[] args) {
		int[] test = {3,1,2,0,4,1,144,23};
		PriorityQueue queue2 = new PriorityQueue();
		for(int i:test)
			queue2.enqueue(i);
		
		for(int i=0;i<test.length;i++)
			System.out.println(queue2.dequeue());
	}
}
