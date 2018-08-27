package visitors;

import elements.Eraser;
import elements.Pencil;

public abstract class Visitor {
	public abstract void visit(Pencil pencil);
	public abstract void visit(Eraser eraser);
}
