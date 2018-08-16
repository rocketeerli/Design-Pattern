package mediator;

public class ConcreteMediator extends AbstractMediator {
	@Override
	public void getRent() {
		super.renter.giveRent();
	}
	@Override
	public void giveRent() {
		super.houseOwner.getRent();
	}
}
