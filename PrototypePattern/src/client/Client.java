package client;

import fruits.Apple;

public class Client {

	public static void main(String[] args) {
		Apple apple1 = new Apple();
		apple1.say();
		Apple apple2 = apple1.clone();
		apple2.say();
	}

}
