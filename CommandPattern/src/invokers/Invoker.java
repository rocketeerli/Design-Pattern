package invokers;

import command.Command;

public class Invoker {
	private Command com;
	
	public void setCommand(Command com) {
		this.com = com;
	}
	
	public void action() {
		this.com.execute();
	}
}
