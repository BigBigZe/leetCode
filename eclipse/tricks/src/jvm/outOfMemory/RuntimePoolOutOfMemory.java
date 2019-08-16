package jvm.outOfMemory;

public class RuntimePoolOutOfMemory {
	
	public static void main(String[] args) {
//		int i=1;
//		String s="";
//		while(true)s+=i;
		String s = new StringBuilder("ja").append("va").toString();

		String s1 = new StringBuilder("计算机").append("软件").toString();
		String s2 = new StringBuilder("计算机122").append("软件").toString();	
		String s3 = "绝对权威";
		String s4 = new String("撒旦大神")+"大神dqw";
//		String s5 = "撒旦大神大神dqw";
		System.out.println(s.intern()==s);
		System.out.println(s1.intern()==s1);
		System.out.println(s2.intern()==s2);
		System.out.println(s3.intern()==s3);
		System.out.println(s4.intern()==s4);
//		System.out.println(s4.intern()==s5);
		System.out.println(s4.toString()==s4.intern());
		System.out.println(s3.toString()==s3.intern());
//		System.out.println(s4==s5);

	}
}
