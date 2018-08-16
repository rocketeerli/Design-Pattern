package mediator;

import colleague.HouseOwner;
import colleague.Renter;

public abstract class AbstractMediator {
	protected Renter renter;
	protected HouseOwner houseOwner;
	
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	
	public Renter getRenter() {
		return renter;
	}
	
	public void setHouseOwner(HouseOwner houseOwner) {
		this.houseOwner = houseOwner;
	}
	
	//收房租。
	public abstract void getRent();
	//交房租。
	public abstract void giveRent();
}
