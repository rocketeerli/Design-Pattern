package client;

import caretakers.Caretaker;
import originator.XiaoMing;

public class Client {

	public static void main(String[] args) {
		XiaoMing xiaoMing = new XiaoMing();
		xiaoMing.setState("高兴");
		System.out.println("小明现在的状态是：" + xiaoMing.getState());
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(xiaoMing.createMemento());
		xiaoMing.setState("伤心");
		System.out.println("小明现在的状态是：" + xiaoMing.getState());
		xiaoMing.restoreMemento(caretaker.getMemento());
		System.out.println("小明现在的状态是：" + xiaoMing.getState());
	}

}
