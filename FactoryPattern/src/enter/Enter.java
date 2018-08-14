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
		
		//��ͨ����ģʽ��
		Producer producer = new ConcreteProducer();
		//����������
		Clothes shirts = producer.produceClothes(Shirt.class);
		shirts.introduce();
		//�������¡�
		Clothes outerwear = producer.produceClothes(Outerwear.class);
		outerwear.introduce();
		//�������ӡ�
		Clothes pants = producer.produceClothes(Pants.class);
		pants.introduce();
		
//		//��̬����ģʽ��
//		Clothes shirts = ConcreteProducer.produceClothes(Shirt.class);
//		shirts.introduce();
//		//�������¡�
//		Clothes outerwear = ConcreteProducer.produceClothes(Outerwear.class);
//		outerwear.introduce();
//		//�������ӡ�
//		Clothes pants = ConcreteProducer.produceClothes(Pants.class);
//		pants.introduce();
		
		
		//�๤��ģʽ��
//		Clothes shirts = (new ShirtProducer()).produceClothes();
//		shirts.introduce();
//		//�������¡�
//		Clothes outerwear = (new OuterwearProducer()).produceClothes();
//		outerwear.introduce();
//		//�������ӡ�
//		Clothes pants = (new PantsProducer()).produceClothes();
//		pants.introduce();
		
	}
}
