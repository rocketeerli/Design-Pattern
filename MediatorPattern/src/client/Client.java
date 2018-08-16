package client;

import colleague.HouseOwner;
import colleague.Renter;
import mediator.AbstractMediator;
import mediator.ConcreteMediator;

public class Client {

	public static void main(String[] args) {
		//定义中介。
		AbstractMediator mediator = new ConcreteMediator();
		//小明和房主。
		Renter xiaoMing = new Renter(mediator);
		HouseOwner houseOwner = new HouseOwner(mediator);
		//小明交房费。
		xiaoMing.giveRent();
		xiaoMing.huoseOwnerReceive();
	}

}
