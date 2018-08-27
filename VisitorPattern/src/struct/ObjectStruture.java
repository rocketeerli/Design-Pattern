package struct;

import java.util.Random;

import elements.Element;
import elements.Eraser;
import elements.Pencil;

public class ObjectStruture {
	public static Element createElement() {
		Random random = new Random();
		if (random.nextInt(100) > 50) {
			return new Pencil();
		} else {
			return new Eraser();
		}
	}
}
