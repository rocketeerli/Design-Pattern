package colleague;

import mediator.AbstractMediator;

public class Renter extends AbstractColleague {
	public Renter(AbstractMediator mediator) {
		super(mediator);
		mediator.setRenter(this);
	}
	//交房租。
	public void giveRent() {
		System.out.println("已交房租...");
	}
	
	//提醒房主收房租。
	public void huoseOwnerReceive() {
		super.mediator.giveRent();
	}
}
