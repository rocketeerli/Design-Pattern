package people;

import tour.Vehicle;

public class Person {
	private Vehicle vehicle;
	public Person(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void travel() {
		this.vehicle.travel();
	}
}
