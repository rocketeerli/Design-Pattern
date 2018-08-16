package colleague;

import mediator.AbstractMediator;

public class HouseOwner extends AbstractColleague {
	public HouseOwner(AbstractMediator mediator) {
		super(mediator);
		mediator.setHouseOwner(this);
	}
	//�շ��⡣
	public void getRent() {
		System.out.println("���յ�����...");
	}
	//�����⡣
	public void requireRent() {
		super.mediator.getRent();
	}
}
