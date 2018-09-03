package collection;

import java.util.Vector;

import iter.ConcreteIterator;
import iter.Iterator;

public class ConcreteAggregate implements Aggregate {
	private Vector<Object> vector = new Vector<>();
	@Override
	public void add(Object object) {
		this.vector.add(object);	
	}
	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this.vector);
	}
	@Override
	public void remove(Object object) {
		this.remove(object);	
	}
}
