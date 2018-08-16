package command;


public class WalkCommand extends Command {
	@Override
	public void execute() {
		super.receiver1.walk();
		super.receiver2.walk();
	}
}
