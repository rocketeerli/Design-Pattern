package enter;

import clothes.Clothes;
import clothes.Outerwear;
import clothes.Pants;
import clothes.Shirt;
import factory.ConcreteProducer;
import factory.OuterwearProducer;
import factory.PantsProducer;
import factory.Producer;
import factory.ShirtProducer;

public class Enter {
	public static void main(String[] args) {
		
		//普通工厂模式。
		Producer producer = new ConcreteProducer();
		//生产衬衫。
		Clothes shirts = producer.produceClothes(Shirt.class);
		shirts.introduce();
		//生产外衣。
		Clothes outerwear = producer.produceClothes(Outerwear.class);
		outerwear.introduce();
		//生产裤子。
		Clothes pants = producer.produceClothes(Pants.class);
		pants.introduce();
		
//		//静态工厂模式。
//		Clothes shirts = ConcreteProducer.produceClothes(Shirt.class);
//		shirts.introduce();
//		//生产外衣。
//		Clothes outerwear = ConcreteProducer.produceClothes(Outerwear.class);
//		outerwear.introduce();
//		//生产裤子。
//		Clothes pants = ConcreteProducer.produceClothes(Pants.class);
//		pants.introduce();
		
		
		//多工厂模式。
//		Clothes shirts = (new ShirtProducer()).produceClothes();
//		shirts.introduce();
//		//生产外衣。
//		Clothes outerwear = (new OuterwearProducer()).produceClothes();
//		outerwear.introduce();
//		//生产裤子。
//		Clothes pants = (new PantsProducer()).produceClothes();
//		pants.introduce();
		
	}
}
