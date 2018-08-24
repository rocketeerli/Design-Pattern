package facade;

import persons.Father;
import persons.Mother;
import persons.XiaoMing;

public class Facade {
	XiaoMing xiaoMing = new XiaoMing();
	Father father = new Father();
	Mother mother = new Mother();
	public void driveCar() {
		this.father.driveCar();
	}
	public void cook() {
		this.mother.cook();
	}
	public void washDishes() {
		this.xiaoMing.washDishes();
	}
}
