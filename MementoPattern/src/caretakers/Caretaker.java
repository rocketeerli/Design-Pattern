package caretakers;

import memento.Memento;

public class Caretaker {
	private Memento mem;
	public Memento getMemento() {
		return this.mem;
	}
	public void setMemento(Memento memento) {
		this.mem = memento;
	}
}
