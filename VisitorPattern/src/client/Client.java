package client;

import elements.Element;
import struct.ObjectStruture;
import visitors.ConcreteVisitor;

public class Client {

	public static void main(String[] args) {
		for (int i = 0; i < 5;i++) {
			Element element = ObjectStruture.createElement();
			element.accept(new ConcreteVisitor());
		}
	}

}
