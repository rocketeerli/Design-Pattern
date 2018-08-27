package elements;

import visitors.Visitor;

public abstract class Element {
	public abstract void getName();
	public abstract void accept(Visitor visitor);
}
