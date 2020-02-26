package dfs.broken_calculator;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public int brokenCalc(int X, int Y) {
        if(X>=Y)return X-Y;
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		int counter = 0;
		queue.add(X);
		while(!queue.isEmpty()) {
			int res = queue.poll();
			if(res==Y)break;
			
			if(res<Y) {
				queue.add(res-1);
				queue.add(res*2);
			}else
				queue.add(res-1);
			counter++;
		}
        return (int)(Math.log(counter)/Math.log(2));
        
    }
    public static void main(String[] args) {
		System.out.println(new Optimization().brokenCalc(3, 10));
	}
}
