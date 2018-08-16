package client;

import colleague.HouseOwner;
import colleague.Renter;
import mediator.AbstractMediator;
import mediator.ConcreteMediator;

public class Client {

	public static void main(String[] args) {
		//�����н顣
		AbstractMediator mediator = new ConcreteMediator();
		//С���ͷ�����
		Renter xiaoMing = new Renter(mediator);
		HouseOwner houseOwner = new HouseOwner(mediator);
		//С�������ѡ�
		xiaoMing.giveRent();
		xiaoMing.huoseOwnerReceive();
	}

}
