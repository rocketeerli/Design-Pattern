package iter;

import java.util.Vector;

public class ConcreteIterator implements Iterator {
	private Vector<Object> vector = new Vector<>();
	public int cursor = 0;
	public ConcreteIterator(Vector<Object> vector) {
		this.vector = vector;
	}
	@Override
	public boolean hasNext() {
		if (this.cursor == this.vector.size()) {
			return false;
		}
		return true;
	}
	@Override
	public Object next() {
		Object result = null;
		if (this.hasNext()) {
			result = this.vector.get(this.cursor++);
		} else {
			result = null;
		}
		return result;
	}
	@Override
	public boolean remove() {
		this.vector.remove(this.cursor);
		return true;
	}
}
