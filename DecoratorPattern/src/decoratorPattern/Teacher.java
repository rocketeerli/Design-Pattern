package decoratorPattern;

public class Teacher extends AbstractPerson implements Person {
	public Teacher(Person person) {
		super(person);
	}
	@Override
	public void talk() {
		super.talk();
		talkOtherThing();
	}
	public void talkOtherThing() {
		System.out.println("I am a teacher");
	}
}
