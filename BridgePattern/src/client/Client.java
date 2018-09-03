package client;

import abstraction.XiaoMing;
import implementor.RiceLunch;

public class Client {

	public static void main(String[] args) {
		XiaoMing xiaoMing = new XiaoMing(new RiceLunch());
		xiaoMing.eatLunch();
	}

}
