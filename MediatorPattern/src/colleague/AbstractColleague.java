package colleague;

import mediator.AbstractMediator;

public abstract class AbstractColleague {
	protected AbstractMediator mediator;
	public AbstractColleague(AbstractMediator mediator) {
		this.mediator = mediator;
	}
}
