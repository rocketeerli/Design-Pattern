package factory;

import clothes.Clothes;

//普通工厂模式。
public class ConcreteProducer extends Producer {
	@Override
	public <T extends Clothes> T produceClothes(Class<T> c) {
		Clothes clothes = null;
		try {
			clothes = (Clothes) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("生产衣服失败!!! ");
		}
		return (T)clothes;
	}
}

////静态工厂模式。
//public class ConcreteProducer {
//	public static <T extends Clothes> T produceClothes(Class<T> c) {
//		Clothes clothes = null;
//		try {
//			clothes = (Clothes) Class.forName(c.getName()).newInstance();
//		} catch (Exception e) {
//			System.out.println("生产衣服失败!!! ");
//		}
//		return (T)clothes;
//	}
//}
