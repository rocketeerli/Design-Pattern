package factory;

import clothes.Clothes;

//��ͨ����ģʽ��
public class ConcreteProducer extends Producer {
	@Override
	public <T extends Clothes> T produceClothes(Class<T> c) {
		Clothes clothes = null;
		try {
			clothes = (Clothes) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("�����·�ʧ��!!! ");
		}
		return (T)clothes;
	}
}

////��̬����ģʽ��
//public class ConcreteProducer {
//	public static <T extends Clothes> T produceClothes(Class<T> c) {
//		Clothes clothes = null;
//		try {
//			clothes = (Clothes) Class.forName(c.getName()).newInstance();
//		} catch (Exception e) {
//			System.out.println("�����·�ʧ��!!! ");
//		}
//		return (T)clothes;
//	}
//}
