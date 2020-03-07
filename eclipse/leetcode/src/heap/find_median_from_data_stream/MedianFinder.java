package heap.find_median_from_data_stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
	
	
    public MedianFinder() {

    }
    
    public void addNum(int num) {
	    max.offer(num);
	    min.offer(max.poll());
	    if(min.size()>max.size())max.offer(min.poll());
    }
    
    public double findMedian() {
    	if(max.size()!=min.size())return max.peek();
    	return (max.peek()+min.peek())*0.5;
    }
}
