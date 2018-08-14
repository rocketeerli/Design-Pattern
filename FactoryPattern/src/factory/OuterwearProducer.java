package factory;

import clothes.Clothes;
import clothes.Outerwear;

public class OuterwearProducer extends Producer2 {
	@Override
	public Clothes produceClothes() {
		return new Outerwear();
	}
}
