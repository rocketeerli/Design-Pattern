package allBuilders;

import product.Bread;
import product.Chicken;
import product.Hamburger;
import product.SmallHamburger;
import product.Vegetables;

public class SmallHamburgerBuilder extends Builder {
	private SmallHamburger smallHamburger = new SmallHamburger();
	@Override
	public void addFood() {
		smallHamburger.addFood(new Bread());
		smallHamburger.addFood(new Vegetables());
		smallHamburger.addFood(new Chicken());
		smallHamburger.addFood(new Bread());
	}
	@Override
	public Hamburger makeHamburger() {
		return smallHamburger;
	}
}
