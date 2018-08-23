package observers;

public class Father implements Observer {
	@Override
	public void see(String context) {
		System.out.println("小明的爸爸收到消息：" + context);
	}
}
