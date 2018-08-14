package factory;

import clothes.Clothes;

public interface ClothesProducer {
	//生产一件衬衫。
	public Clothes produceShirt();
	//生产一件外套。
	public Clothes produceOuterwear();
	//生产一条裤子。
	public Clothes producePants();
}
