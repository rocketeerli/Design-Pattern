package client;

import people.Person;
import tour.Airplane;
import tour.Train;

public class Client {

	public static void main(String[] args) {
		System.out.println("小明去旅游---------------");
		Person xiaoMing = new Person(new Airplane());
		xiaoMing.travel();
		System.out.println("小红去旅游---------------");
		Person xiaoHong = new Person(new Train());
		xiaoHong.travel();
	}

}
