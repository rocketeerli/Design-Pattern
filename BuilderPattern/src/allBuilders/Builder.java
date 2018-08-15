package allBuilders;

import product.Hamburger;

public abstract class Builder {
	public abstract void addFood();
	public abstract Hamburger makeHamburger();
}
