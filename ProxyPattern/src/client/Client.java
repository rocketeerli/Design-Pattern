package client;

import driver.CarOwner;
import driver.Driver;

public class Client {

	public static void main(String[] args) {
		Driver you = new CarOwner();
		Driver proxy = you.getProxy();
		proxy.driveCar();
	}

}
