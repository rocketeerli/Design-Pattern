package client;

import adaptors.Adapter;
import birds.Bird;
import birds.Swallow;

public class Client {
	public static void main(String[] args) {
		Bird swallow = new Swallow();
		swallow.fly();
		Bird wildGoose = new Adapter();
		wildGoose.fly();
	}
}
