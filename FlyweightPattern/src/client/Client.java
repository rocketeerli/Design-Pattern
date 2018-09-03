package client;

import factory.FlyweightFactory;
import flyweight.Pen;

public class Client {

	public static void main(String[] args) {
		Pen pen1 = FlyweightFactory.getPen("HB");
		pen1.introduce();
		Pen pen2 = FlyweightFactory.getPen("2B");
		pen2.introduce();
		Pen pen4 = FlyweightFactory.getPen("4B");
		pen4.introduce();
		
		Pen pen5 = FlyweightFactory.getPen("2B");
		pen5.introduce();
		Pen pen6 = FlyweightFactory.getPen("4B");
		pen6.introduce();
	}

}
