# 介绍


----------

建造者模式属于创建型模式中较高级的一种模式，它一般是在创建由其他简单对象组成的复杂对象时使用，将创建时的构建细节和表示分离开。一般是将组成对象的各个部分按一定的顺序组合在一起，然后创建对象。定义如下：

> Separate the construction of a complex object from its representation so that the same construction process can create different representations. <br/>
> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

简单地说，该模式适用于**创建由不同组合的简单对象构成的复杂对象。** 或是 **相同方法，不同执行顺序的一组对象。**

举例之前，首先需要说明一下使用建造者模式需要的几个部分：

 1. 产品类（Product）：包括我们的复杂对象及其组成部分。
 2. 抽象建造者（Builder）：用于规范产品的组建，由子类实现。
 3. 具体建造者（ConcreteBuilder）：实现抽象建造者的方法，并且返回一个具体产品，最终的产品就是由它创建。
 4. 导演类（Director）：负责调用具体建造者，用它来创建各种不同组合的产品，并利用它开放更具体的创建方法给客户端。

# 例子


----------

我们都知道，汉堡的制作需要多道程序，而且由于组成不同，汉堡有不同的口味，今天我们就做一次汉堡。这个汉堡有两种——小汉堡和大汉堡。

那么首先就需要创建产品类：

首先创建食物接口：

	public interface Food {
		public String getName();
	}

然后有三个实现类：

面包：

	public class Bread implements Food {
		@Override
		public String getName() {
			return "面包";
		}
	}

蔬菜：

	public class Vegetables implements Food {
		@Override
		public String getName() {
			return "蔬菜";
		}
	}

鸡肉：

	public class Chicken implements Food {
		@Override
		public String getName() {
			return "鸡肉";
		}
	}

然后是抽象汉堡类：

	public abstract class Hamburger {
		private List<Food> part = new ArrayList<>();
		
		public void addFood(Food food) {
			part.add(food);
		}
		
		public void showFood() {
			System.out.println("汉堡组成：");
			for (Food food : part) {
				System.out.print(food.getName() + "\t");
			}
			System.out.println("");
		}
	}


大汉堡：

	public class BigHamburger extends Hamburger {
	}

小汉堡：

	public class SmallHamburger extends Hamburger {
	}

OK，产品定义完成，下面就该我们生产了，首先创建抽象创建者：

	public abstract class Builder {
		public abstract void addFood();
		public abstract Hamburger makeHamburger();
	}

然后创建我们的具体创建者。

大汉堡创建者：

	public class BigHamburgerBuilder extends Builder {
		private BigHamburger bigHamburger = new BigHamburger();
		@Override
		public void addFood() {
			bigHamburger.addFood(new Bread());
			bigHamburger.addFood(new Vegetables());
			bigHamburger.addFood(new Chicken());
			bigHamburger.addFood(new Vegetables());
			bigHamburger.addFood(new Chicken());
			bigHamburger.addFood(new Bread());
		}
		@Override
		public Hamburger makeHamburger() {
			return bigHamburger;
		}
	}

小汉堡创建者：

	public class SmallHamburgerBuilder extends Builder {
		private SmallHamburger smallHamburger = new SmallHamburger();
		@Override
		public void addFood() {
			smallHamburger.addFood(new Bread());
			smallHamburger.addFood(new Vegetables());
			smallHamburger.addFood(new Chicken());
			smallHamburger.addFood(new Bread());
		}
		@Override
		public Hamburger makeHamburger() {
			return smallHamburger;
		}
	}

最后是我们的导演类，负责调用创建者类进行创建：

	public class Director {
		private Builder bigHamburgerBuilder = new BigHamburgerBuilder();
		private Builder smallHamburgerBuilder = new SmallHamburgerBuilder();
		
		public Hamburger makeBigHamburger() {
			bigHamburgerBuilder.addFood();
			return bigHamburgerBuilder.makeHamburger();
		}
		
		public Hamburger makeSmallHamburger() {
			smallHamburgerBuilder.addFood();
			return smallHamburgerBuilder.makeHamburger();
		}
	}

OK，四部分组件已经创建好了，剩下就是和客户端调用了，下面我们来测试一下：

	Director director = new Director();
	Hamburger bigHamburger = director.makeBigHamburger();
	Hamburger samllHamburger = director.makeSmallHamburger();
	bigHamburger.showFood();
	samllHamburger.showFood();

输出结果为：

> 汉堡组成：<br/>
面包	蔬菜	鸡肉	蔬菜	鸡肉	面包<br/>	
汉堡组成：<br/>
面包	蔬菜	鸡肉	面包	


可以看到仅仅只用了两行代码，就成功地创建了两个汉堡，而且这两个汉堡的组合方式不同。这就是建造者模式，通过这四部分，一层一层地将底层封装起来，最后交给客户端的是非常简洁的 `API`。
# 总结


----------
建造者模式和工厂模式很相似，都是将对象的底层封装起来，创建时不需要考虑对象的细节。唯一的区别在于，建造者模式更关注于对象的组成顺序，较工厂模式更为高级一些，但同时也更复杂。

此外，建造者模式也可以用于创建方法执行顺序不同的对象，此时更多的是与模板方法模式结合使用，结构是一样的，只不过简单对象换成了各种方法。

<br/>