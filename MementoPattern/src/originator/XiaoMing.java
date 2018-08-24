package originator;

import memento.Memento;

public class XiaoMing {
	private String state = "";
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Memento createMemento() {
		return new Memento(this.state);
	}
	public void restoreMemento(Memento memento) {
		this.setState(memento.getState());
	}
}
