# 介绍


----------
工厂模式属于创建类设计模式中非常基础的一种，对于它的定义是这样的：

> Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
 <br>
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

这么说的可能太官方，通俗地讲，工厂模式就是将创建对象的事情交给一个工厂类，客户端想要创建对象的时候，只需要调用工厂类中的方法就能实例化一个类，而不用使用 `A a = new A()` 的方式创建。

工厂模式一般是用来创建复杂对象采用的一种方式，因为简单对象就可以直接使用 `new` 的方式创建。当然，是否使用还是要视具体情况而定。

下面来介绍工厂模式及其扩展的两种模式。

# 工厂模式


----------

工厂模式要实现的话，需要三步：

* 首先定义我们要创建的产品，它们共同实现一个接口。
* 然后，需要一个工厂类，这是最主要的，因为它负责对象的创建。
* 最后利用客户端调用即可。

我们来举一个例子，如果有一个工厂要生产衣服，然后利用工厂来生产各种不同的衣服（衬衫，外衣和裤子）。这样我们就可以通过工厂进行衣服的生产了。

首先我们需要创建衣服接口：

	public interface Clothes {
		public void introduce();
	}

然后定义三种衣服的实现类

衬衫：

	public class Shirt implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是衬衫!!! ");
		}
	}

外衣：

	public class Outerwear implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是外衣!!! ");
		}
	}

裤子：

	public class Pants implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是裤子!!! ");
		}
	}

好了，产品已经定义好了，接下来就是如何进行创建了，这里我们不直接使用 `new` 的方式，而是通过工厂间接进行创建。

抽象工厂类：

	public abstract class Producer {
		public abstract <T extends Clothes> T produceClothes(Class<T> c);
	}

具体工厂类：

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

产品有了，工厂也有了，客户端就可以这样调用：

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

可以查看输出：

> 我是衬衫!!! <br>
我是外衣!!! <br>
我是裤子!!! 

这样，我们就将创建对象的过程移到客户端代码外了。客户端只需要输入要创建对象的信息即可（信息可以是String、Enum、Class 等，这里使用了 Class ）。

# 静态工厂模式（简单工厂模式）


----------

静态工厂是工厂模式的一种简化版本，它直接工厂类进行改造，去掉了抽象工厂类，将工厂中的创建函数设为全局模式（ `static` ）。

还是上面的代码，产品不变，工厂类变为一个，函数设为全局：

	public class ConcreteProducer {
		public static <T extends Clothes> T produceClothes(Class<T> c) {
			Clothes clothes = null;
			try {
				clothes = (Clothes) Class.forName(c.getName()).newInstance();
			} catch (Exception e) {
				System.out.println("生产衣服失败!!! ");
			}
			return (T)clothes;
		}
	}

然后客户端就可以直接利用 `ConcreteProducer` 进行创建，而不用再去 `new` 一个工厂类了：

	Clothes shirts = ConcreteProducer.produceClothes(Shirt.class);
	shirts.introduce();
	//生产外衣。
	Clothes outerwear = ConcreteProducer.produceClothes(Outerwear.class);
	outerwear.introduce();
	//生产裤子。
	Clothes pants = ConcreteProducer.produceClothes(Pants.class);
	pants.introduce();

输出结果为：

> 我是衬衫!!! <br>
我是外衣!!! <br>
我是裤子!!! 

这就是静态工厂模式——简化版的工厂模式。

# 多工厂模式


----------
多工厂模式要求我们，有多少实现类就创建多少工厂，客户端调用的时候，就可以直接使用具体的实现类的工厂创建了，而不是传入类型参数。

还是上面的三种衣服，在这种模式中，我们就需要创建三种具体工厂：

抽象工厂接口：

	public abstract class Producer2 {
		public abstract Clothes produceClothes();
	}

衬衫：

	public class ShirtProducer extends Producer2 {
		@Override
		public Clothes produceClothes() {
			return new Shirt();
		}
	}

外衣：

	public class OuterwearProducer extends Producer2 {
		@Override
		public Clothes produceClothes() {
			return new Outerwear();
		}
	}

裤子：

	public class OuterwearProducer extends Producer2 {
		@Override
		public Clothes produceClothes() {
			return new Outerwear();
		}
	}

这样，客户端就可以使用具体的工厂方法创建对象了：

	Clothes shirts = (new ShirtProducer()).produceClothes();
	shirts.introduce();
	//生产外衣。
	Clothes outerwear = (new OuterwearProducer()).produceClothes();
	outerwear.introduce();
	//生产裤子。
	Clothes pants = (new PantsProducer()).produceClothes();
	pants.introduce();

> 我是衬衫!!! <br>
我是外衣!!! <br>
我是裤子!!! 

这样我们就可以直接使用具体的工厂来进行创建了，由于不只有一个工厂，有多少实现类就有多少具体工厂，因此成为多工厂模式。然而该模式最大的缺陷之处也正是在这，太多的工厂类会造成项目特别臃肿，降低可维护性。

# 总结


----------


工厂模式是一种简单的创建类设计模式，易于理解，而且对于创建复杂对象十分有效，因此在很多项目中都能看到它的身影。