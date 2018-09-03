package factory;

import java.util.HashMap;

import flyweight.Pen;
import flyweight.Pencil;

public class FlyweightFactory {
	public static HashMap<String, Pen> pool = new HashMap<>();
	public static Pen getPen(String penType) {
		Pen pen = null;
		if (pool.containsKey(penType)) {
			pen = pool.get(penType);
		} else {
			pen = new Pencil(penType);
			pool.put(penType, pen);
		}
		return pen;
	}
}
