package abstraction;

import implementor.Lunch;

public abstract class Person {
	private Lunch lunch;
	public Person(Lunch lunch) {
		this.lunch = lunch;
	}
	public void eatLunch() {
		this.lunch.eatLunch();
	}
	public Lunch getLunch() {
		return this.lunch;
	}
}
