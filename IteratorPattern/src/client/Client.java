package client;

import collection.Aggregate;
import collection.ConcreteAggregate;
import iter.Iterator;

public class Client {
	public static void main(String[] args) {
		Aggregate aggregate = new ConcreteAggregate();
		aggregate.add("Æ»¹û");
		aggregate.add("éÙ×Ó");
		aggregate.add("Ïã½¶");
		Iterator iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
