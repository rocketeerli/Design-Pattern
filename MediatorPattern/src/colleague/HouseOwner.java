package colleague;

import mediator.AbstractMediator;

public class HouseOwner extends AbstractColleague {
	public HouseOwner(AbstractMediator mediator) {
		super(mediator);
		mediator.setHouseOwner(this);
	}
	//收房租。
	public void getRent() {
		System.out.println("已收到房租...");
	}
	//交房租。
	public void requireRent() {
		super.mediator.getRent();
	}
}
