package factory;

import clothes.Clothes;
import clothes.Pants;

public class PantsProducer extends Producer2 {
	@Override
	public Clothes produceClothes() {
		return new Pants();
	}
}
