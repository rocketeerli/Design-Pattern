package client;

import cont.Context;

public class Client {

	public static void main(String[] args) {
		Context context = new Context();
		context.close();
		context.open();
		context.close();
	}

}
