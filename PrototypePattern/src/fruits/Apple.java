package fruits;

public class Apple implements Cloneable {
	public void say() {
		System.out.println("����ƻ��...");
	}
	@Override
	public Apple clone() {
		Apple apple = null;
		try {
			apple = (Apple)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("����ʧ��!!!");
		}
		return apple;
	}
}
