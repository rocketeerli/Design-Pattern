package decoratorPattern;

public class GoodPerson implements Person{
	public GoodPerson() {
		
	}
	@Override
	public void talk() {
		System.out.println("I am a good person");
	}
}
