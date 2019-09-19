package heap.binaryHeap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	
	private static final int defaultSize = 11;
	
	int currentSize;
	
	int[] tree ;
	
	
	public Heap() {
		this.currentSize = 0;
		this.tree = new int[defaultSize];
	}
	
	public Heap(int size) {
		this.currentSize = 0;
		this.tree = new int[size+1];
	}
	
	public void insert(int x) {
		int hole = ++currentSize;
		for(tree[0] = x;hole>1&&x<tree[hole/2];hole/=2) 
			tree[hole] = tree[hole/2];
		tree[hole] = x;

	}
	
	public void print() {
		for(int i=1;i<=currentSize;i++)
			System.out.print(tree[i]+" ");
		System.out.println();
	}
	
	public int remove() {
		int res = tree[1];
		int x = tree[currentSize];
		tree[currentSize--] = 0;
		int hole = 1;
		int child;
		for(;hole*2<=currentSize;hole = child) {
			child = hole*2;
			if(child<=currentSize&&tree[child+1]!=0&&tree[child+1]<tree[child])
				child++;
			if(tree[child]<x)
				tree[hole] = tree[child];
			else break;
			
		}
		tree[hole] = x;
		System.out.println("remove:"+res);
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,12,5,6,7,2,1,9,8};
		Heap heap = new Heap(nums.length);
		for(int i:nums)heap.insert(i);
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
	}
	
}
