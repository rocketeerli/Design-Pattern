package enter;

import clothes.Clothes;
import factory.AmericanFactory;
import factory.ChineseFactory;
import factory.ClothesProducer;

public class Enter {
	public static void main(String[] args) {
		//中国工厂。
		ClothesProducer factoryChinese  = new ChineseFactory();
		//美国工厂。
		ClothesProducer factortAmerican = new AmericanFactory();
		
		System.out.println("生产一条中国裤子-------------");
		Clothes pants_China = factoryChinese.producePants();
		pants_China.introduce();
		pants_China.getPlace();
		
		System.out.println("生产一件美国衬衫-------------");
		Clothes shirt_America = factortAmerican.produceShirt();
		shirt_America.introduce();
		shirt_America.getPlace();
	}
}
