package cont;

import states.CloseState;
import states.OpenState;
import states.State;

public class Context {
	public final static State OPENSTATE = new OpenState();
	public final static State CLOSESTATE = new CloseState();
	private State currentState = CLOSESTATE;
	public void open() {
		this.currentState.open();
		this.currentState = OPENSTATE;
	}
	public void close() {
		this.currentState.close();
		this.currentState = CLOSESTATE;
	}
}
