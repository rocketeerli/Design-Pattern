package director;

import allBuilders.BigHamburgerBuilder;
import allBuilders.Builder;
import allBuilders.SmallHamburgerBuilder;
import product.Hamburger;

public class Director {
	private Builder bigHamburgerBuilder = new BigHamburgerBuilder();
	private Builder smallHamburgerBuilder = new SmallHamburgerBuilder();
	
	public Hamburger makeBigHamburger() {
		bigHamburgerBuilder.addFood();
		return bigHamburgerBuilder.makeHamburger();
	}
	
	public Hamburger makeSmallHamburger() {
		smallHamburgerBuilder.addFood();
		return smallHamburgerBuilder.makeHamburger();
	}
}
