# 介绍


----------
抽象工厂模式是工厂方法模式的升级版，当实现类非常多的时候，而且实现类之间关系复杂的时候，只利用一个工厂创建所有的实现类显然是不可能的，那么该如何创建呢？这就需要创建工厂的工厂类了，也就是我们的抽象工厂模式。

抽象工厂模式的定义是这样的：

> Provide an interface for creating families of related or dependent objects without specifying their concrete classes.<br/>
> 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类。

抽象工厂模式与工厂模式最大的区别就是 **抽象工厂相当于对工厂方法做了一层的封装。** 抽象工厂模式中的工厂类创建具体类的工厂，然后由这些工厂去创建实现类。相当于多个工厂方法的组合，然而，不同的是，这些创建的工厂类之间是有联系的并不是随意地组合在一起的。

下面还是看一下利用工厂生产衣服的例子。


# 例子


----------
在工厂方法模式中，我们提到利用工厂生产三种不同的衣服（衬衫、外套和裤子）。然而，项目是一直变化的，今天工厂在美国上市了，要在美国布置生产流水线，那么这时就出现问题了，因为有美国生产的衣服和中国生产的衣服之分，这时就需要修改我们的程序了。

如何修改呢？所有衣服还是有三种，然而每种衣服都有两个生产地，因此，这样就会产生六个实现类。那么该如何实现呢？

首先还是需要创建所有的衣服的接口：

	public interface Clothes {
		public void introduce();
		public void getPlace();
	}

然后实现三种衣服的抽象类

衬衫：

	public abstract class Shirt implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是衬衫!!! ");
		}
	}

外套：

	public abstract class Outerwear implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是外衣!!! ");
		}
	}

裤子：

	public abstract class Pants implements Clothes {
		@Override
		public void introduce() {
			System.out.println("我是裤子!!! ");
		}
	}


接口完成后，实现六种实现类：

中国衬衫：

	public class ChineseShirt extends Shirt {
		public void getPlace() {
			System.out.println("产自中国!!! ");
		}
	}

美国衬衫：

	public class AmericanShirt extends Shirt {
		public void getPlace() {
			System.out.println("产自美国!!! ");
		}
	}


...其他四种实现类是一样的形式，就不一一书写代码了。

到现在为止，六种衣服已经定义好了，该到我们的重点了——工厂类。工厂类该如何写呢，我们应该有两种工厂，一种创建美国的衣服，一种创建中国的衣服，两种工厂共同实现一个生产衣服的接口：

	public interface ClothesProducer {
		//生产一件衬衫。
		public Clothes produceShirt();
		//生产一件外套。
		public Clothes produceOuterwear();
		//生产一条裤子。
		public Clothes producePants();
	}

中国工厂：

	public class ChineseFactory implements ClothesProducer {
		@Override
		public Clothes produceShirt() {
			return new ChineseShirt();
		}
		@Override
		public Clothes produceOuterwear() {
			return new ChineseOuterwear();
		}
		@Override
		public Clothes producePants() {
			return new ChinesePants();
		}
	}

美国工厂：

	public class AmericanFactory implements ClothesProducer {
		@Override
		public Clothes produceShirt() {
			return new AmericanShirt();
		}
		
		@Override
		public Clothes produceOuterwear() {
			return new AmericanOuterwear();
		}
		
		@Override
		public Clothes producePants() {
			return new AmericanPants();
		}
	}

产品有了，工厂也都全了，剩下的就是客户端调用了：

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

输出结果为：

> 生产一条中国裤子-------------<br>
我是裤子!!! <br>
产自中国!!! <br>
生产一件美国衬衫-------------<br>
我是衬衫!!! <br>
产自美国!!! 

在客户端代码中，没有任何一个方法与实现类有关系，我们只要知道它的工厂方法，就能直接创建一个产品，生产一件衣服，而不需要知道它的实现类是怎么实现的。

# 总结


----------
抽象工厂适合于创建**大量有关联的**对象组，例如，在不同操作系统环境下的java虚拟机是不同的，这样我们就可以创建多种操作系统环境，然后在不同环境下去实现具体的java虚拟机，这时利用抽象工厂模式就非常合适。