package factory;

import clothes.Clothes;
import clothes.Shirt;

public class ShirtProducer extends Producer2 {
	@Override
	public Clothes produceClothes() {
		return new Shirt();
	}
}
