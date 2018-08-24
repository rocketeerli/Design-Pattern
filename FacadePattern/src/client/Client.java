package client;

import facade.Facade;

public class Client {

	public static void main(String[] args) {
		Facade fac = new Facade();
		fac.driveCar();
		fac.cook();
		fac.washDishes();
	}

}
