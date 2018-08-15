package client;

import director.Director;
import product.Hamburger;

public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		Hamburger bigHamburger = director.makeBigHamburger();
		Hamburger samllHamburger = director.makeSmallHamburger();
		bigHamburger.showFood();
		samllHamburger.showFood();
	}
}
