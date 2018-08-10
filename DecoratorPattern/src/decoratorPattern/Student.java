package decoratorPattern;

public class Student extends AbstractPerson implements Person{
	public Student(Person person) {
		super(person);
	}
	@Override
	public void talk() {
		super.talk();
		talkOtherThing();
	}
	public void talkOtherThing() {
		System.out.println("I am a student");
	}
}
