package client;

import people.Person;
import tour.Airplane;
import tour.Train;

public class Client {

	public static void main(String[] args) {
		System.out.println("С��ȥ����---------------");
		Person xiaoMing = new Person(new Airplane());
		xiaoMing.travel();
		System.out.println("С��ȥ����---------------");
		Person xiaoHong = new Person(new Train());
		xiaoHong.travel();
	}

}
