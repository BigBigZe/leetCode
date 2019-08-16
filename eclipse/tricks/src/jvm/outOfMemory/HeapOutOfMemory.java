package jvm.outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM arguments
 * -verbose : gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 	和书上的运行结果不太一样
 * @author zone
 *
 */
public class HeapOutOfMemory {

	static class OOMObject {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OOMObject> list = new ArrayList<>();
		
		while(true) {
			list.add(new OOMObject());
		}
	}

}
