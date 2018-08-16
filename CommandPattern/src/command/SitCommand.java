package command;


public class SitCommand extends Command {
	@Override
	public void execute() {
		super.receiver1.sit();
		super.receiver2.sit();
	}
}
