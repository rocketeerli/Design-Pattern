package receivers;

public class Cat extends Receiver {
	@Override
	public void walk() {
		System.out.println("猫在走...");
	}
	@Override
	public void sit() {
		System.out.println("猫坐下了...");
	}
}
