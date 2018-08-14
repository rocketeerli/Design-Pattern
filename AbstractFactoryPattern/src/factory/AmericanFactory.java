package factory;

import clothes.AmericanOuterwear;
import clothes.AmericanPants;
import clothes.AmericanShirt;
import clothes.Clothes;

public class AmericanFactory implements ClothesProducer {
	@Override
	public Clothes produceShirt() {
		return new AmericanShirt();
	}
	
	@Override
	public Clothes produceOuterwear() {
		return new AmericanOuterwear();
	}
	
	@Override
	public Clothes producePants() {
		return new AmericanPants();
	}
}
