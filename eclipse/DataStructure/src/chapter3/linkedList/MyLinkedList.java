package chapter3.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	A a = new A();
	private class A{
		public int a;
		private int b;
	}
	
	public void test() {
		this.a.b = 1; 
		/*
		 * 注意这里b即使在内部类中设为了private，在MyLinkedList仍然可见
		 * */
	}
	
	public static void main(String[] args) {
		List<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		Iterator<Integer> iterator = l.iterator();
		iterator.next();
		iterator.remove();
		iterator.remove();
		for (Integer integer : l) {
			System.out.println(integer);
		}
	}

}
