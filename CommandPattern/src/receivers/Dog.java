package receivers;

public class Dog extends Receiver {
	@Override
	public void walk() {
		System.out.println("狗在走...");
	}
	@Override
	public void sit() {
		System.out.println("狗坐下了...");
	}
}
