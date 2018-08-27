package elements;

import visitors.Visitor;

public class Pencil extends Element {
	@Override
	public void getName() {
		System.out.println("Ç¦±Ê");
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
