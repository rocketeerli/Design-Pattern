package observers;

public class Mother implements Observer {
	@Override
	public void see(String context) {
		System.out.println("小明的妈妈收到消息：" + context);
	}
}
