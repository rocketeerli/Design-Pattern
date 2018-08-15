package allBuilders;

import product.BigHamburger;
import product.Bread;
import product.Chicken;
import product.Hamburger;
import product.Vegetables;

public class BigHamburgerBuilder extends Builder {
	private BigHamburger bigHamburger = new BigHamburger();
	@Override
	public void addFood() {
		bigHamburger.addFood(new Bread());
		bigHamburger.addFood(new Vegetables());
		bigHamburger.addFood(new Chicken());
		bigHamburger.addFood(new Vegetables());
		bigHamburger.addFood(new Chicken());
		bigHamburger.addFood(new Bread());
	}
	@Override
	public Hamburger makeHamburger() {
		return bigHamburger;
	}
}
