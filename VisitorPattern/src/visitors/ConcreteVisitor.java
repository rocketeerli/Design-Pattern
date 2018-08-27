package visitors;

import elements.Eraser;
import elements.Pencil;

public class ConcreteVisitor extends Visitor {
	@Override
	public void visit(Pencil pencil) {
		pencil.getName();
		System.out.println("拿到了铅笔");
	}
	@Override
	public void visit(Eraser eraser) {
		eraser.getName();
		System.out.println("拿到了橡皮");
	}
}
