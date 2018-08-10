package singletonPattern;

// ����ʽ
//public class Singleton {
//	private static Singleton singleton;
//
//	private Singleton() {
//	}
//	
//	public static synchronized Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}

////����ʽ
//public class Singleton {
//	private static Singleton singleton = new Singleton();
//
//	private Singleton() {
//	}
//	
//	public static synchronized Singleton getInstance() {
//		return singleton;
//	}
//}

////��̬�ڲ���
//public class Singleton {  
//	private static class SingletonHolder {  
//	   private static final Singleton INSTANCE = new Singleton();  
//	}  
//	private Singleton (){
//	}  
//	public static final Singleton getInstance() {  
//		return SingletonHolder.INSTANCE;  
//	}  
//}

// ˫��У����
public class Singleton {  
	private volatile static Singleton singleton;  
	private Singleton (){
	}  
	public static Singleton getSingleton() {  
	if (singleton == null) {  
		synchronized (Singleton.class) {  
			if (singleton == null) {  
				singleton = new Singleton();  
			}  
	    }  
	}  
	return singleton;  
	}  
}
