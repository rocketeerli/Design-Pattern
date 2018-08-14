package factory;

import clothes.Clothes;

public abstract class Producer {
	public abstract <T extends Clothes> T produceClothes(Class<T> c);
}
