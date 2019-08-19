package jvm.garbage_collection;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("yes,i am still alive :)");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		SAVE_HOOK = new FinalizeEscapeGC();
		
		//对象第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		//因为finalize方法优先级很低，所以暂停0.5s等候他
		Thread.sleep(500);
		if(SAVE_HOOK!=null) {
			SAVE_HOOK.isAlive();
		}else
			System.out.println("no, i am dead :(");
		
		SAVE_HOOK = null;
		System.gc();
		//因为finalize方法优先级很低，所以暂停0.5s等候他
		Thread.sleep(500);
		if(SAVE_HOOK!=null) {
			SAVE_HOOK.isAlive();
		}else
			System.out.println("no, i am dead :(");
	}

}
