package client;

import observers.Father;
import observers.Mother;
import observers.Observer;
import subjects.XiaoMing;

public class Client {

	public static void main(String[] args) {
		XiaoMing xiaoMing = new XiaoMing();
		Observer father = new Father();
		Observer mother = new Mother();
		xiaoMing.addObserver(mother);
		xiaoMing.addObserver(father);
		xiaoMing.eat();
		xiaoMing.doHomework();
	}

}
