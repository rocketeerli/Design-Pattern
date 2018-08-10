package decoratorPattern;

public class Father extends AbstractPerson implements Person {
	public Father(Person person) {
		super(person);
	}
	@Override
	public void talk() {
		super.talk();
		talkOtherThing();
	}
	public void talkOtherThing() {
		System.out.println("I am a father");
	}
}
