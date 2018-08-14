package factory;

import clothes.ChineseOuterwear;
import clothes.ChinesePants;
import clothes.ChineseShirt;
import clothes.Clothes;

public class ChineseFactory implements ClothesProducer {
	@Override
	public Clothes produceShirt() {
		return new ChineseShirt();
	}
	@Override
	public Clothes produceOuterwear() {
		return new ChineseOuterwear();
	}
	@Override
	public Clothes producePants() {
		return new ChinesePants();
	}
}
