package factory;

import clothes.Clothes;

public interface ClothesProducer {
	//����һ��������
	public Clothes produceShirt();
	//����һ�����ס�
	public Clothes produceOuterwear();
	//����һ�����ӡ�
	public Clothes producePants();
}
