package states;

import cont.Context;

public abstract class State {
	protected Context context;
	public void setContext(Context context) {
		this.context = context;
	}
	public abstract void open();
	public abstract void close();
}
