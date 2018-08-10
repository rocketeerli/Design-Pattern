package decoratorPattern;

public abstract class AbstractPerson implements Person {
	protected final Person person;
	public AbstractPerson(Person person) {
		this.person = person;
	}
	@Override
	public void talk() {
		person.talk();
	}
}
