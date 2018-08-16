package colleague;

import mediator.AbstractMediator;

public class Renter extends AbstractColleague {
	public Renter(AbstractMediator mediator) {
		super(mediator);
		mediator.setRenter(this);
	}
	//�����⡣
	public void giveRent() {
		System.out.println("�ѽ�����...");
	}
	
	//���ѷ����շ��⡣
	public void huoseOwnerReceive() {
		super.mediator.giveRent();
	}
}
