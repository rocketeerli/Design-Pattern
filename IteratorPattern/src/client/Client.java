package client;

import collection.Aggregate;
import collection.ConcreteAggregate;
import iter.Iterator;

public class Client {
	public static void main(String[] args) {
		Aggregate aggregate = new ConcreteAggregate();
		aggregate.add("ƻ��");
		aggregate.add("����");
		aggregate.add("�㽶");
		Iterator iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
