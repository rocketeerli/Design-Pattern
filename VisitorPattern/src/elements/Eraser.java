package elements;

import visitors.Visitor;

public class Eraser extends Element {
	@Override
	public void getName() {
		System.out.println("��Ƥ");
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
