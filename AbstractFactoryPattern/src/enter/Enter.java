package enter;

import clothes.Clothes;
import factory.AmericanFactory;
import factory.ChineseFactory;
import factory.ClothesProducer;

public class Enter {
	public static void main(String[] args) {
		//�й�������
		ClothesProducer factoryChinese  = new ChineseFactory();
		//����������
		ClothesProducer factortAmerican = new AmericanFactory();
		
		System.out.println("����һ���й�����-------------");
		Clothes pants_China = factoryChinese.producePants();
		pants_China.introduce();
		pants_China.getPlace();
		
		System.out.println("����һ����������-------------");
		Clothes shirt_America = factortAmerican.produceShirt();
		shirt_America.introduce();
		shirt_America.getPlace();
	}
}
