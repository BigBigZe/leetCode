package jvm.outOfMemory;
/**
 *  VM args(one thread):
 * 	-Xss 180k(at least)
 * @author zone
 *	实验结果表明，单线程下，无论是栈帧太大或是虚拟机栈容量太小，当内存无法分配时，都会
 *	抛出StackOverflowError
 *
 *	VM args(many thread):
 * 	-Xss 2MB
 *	多线程情况不敢试，怕死机。这种情况下会很容易导致内存溢出，因为除去JVM中堆、程序计数器、
 *	以及本机已经消耗的内存，剩下的内存都将分配给栈，当不断产生新线程时，每产生一个，就消耗
 *	2MB
 */
public class StackOutOfMemory {
	
	private int stacklength = 1;
	
	public void stackLeak() {
		stacklength++;
		stackLeak();
	}
	
	public void byThreads() {
		while(true) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					stackLeak();
				}
			});
			t.start();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOutOfMemory stackOutOfMemory = new StackOutOfMemory();
		try {
			stackOutOfMemory.stackLeak();
		}catch (Throwable e) {
			System.out.println("stack length:"+stackOutOfMemory.stacklength);
			throw e;
			// TODO: handle exception
		}
		
//		stackOutOfMemory.byThreads();
	}

}
