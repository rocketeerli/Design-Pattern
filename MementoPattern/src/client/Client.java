package client;

import caretakers.Caretaker;
import originator.XiaoMing;

public class Client {

	public static void main(String[] args) {
		XiaoMing xiaoMing = new XiaoMing();
		xiaoMing.setState("����");
		System.out.println("С�����ڵ�״̬�ǣ�" + xiaoMing.getState());
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(xiaoMing.createMemento());
		xiaoMing.setState("����");
		System.out.println("С�����ڵ�״̬�ǣ�" + xiaoMing.getState());
		xiaoMing.restoreMemento(caretaker.getMemento());
		System.out.println("С�����ڵ�״̬�ǣ�" + xiaoMing.getState());
	}

}
