# 介绍

------------------

外观模式也叫做门面模式，是一种结构型设计模式。它将一系列的类封装起来，避免其他类直接访问这些类，如果要访问这些类，必须经过这个封装的类。这个封装的类就相当于这系列类的门面一样。下面先来看一下外观模式的定义：

> Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.<br/>
> 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供一个高层次的接口，使得子系统更易于使用。

外观类封装了一系列的类，**只有通过该类才能访问这些类**，就像有一个类将所有的类都包装起来，**内部类有的方法包装类都有。**客户端调用一个方法时，并不知道哪个类去执行该方法，仅仅只是通过这个封装类进行调用。

外观模式主要有两种角色：

* Facade门面角色。
该角色持有所有内部类的对象，并且包含内部类中所有的方法，客户端通过调用该角色的方法来间接访问内部的子类。

* subsystem子系统角色。
子系统相当于多个类的集合，门面角色将其封装起来，使得客户端并不能直接调用它们的方法。子系统可以有多个。

# 例子

---------------------

现在小明一家人要出去野餐，三个人都有自己的任务（开车，做饭，洗碗），那么这时候就要有三个类：

父亲：

	public class Father {
		public void driveCar() {
			System.out.println("小明的爸爸在开车");
		}
	}

母亲：

	public class Mother {
		public void cook() {
			System.out.println("小明的妈妈在做饭");
		}
	}

小明：

	public class XiaoMing {
		public void washDishes() {
			System.out.println("小明在洗碗");
		}
	}

我们要把这三个任务合到一起，统一开放给外部，那么就需要一个封装类：

	public class Facade {
		XiaoMing xiaoMing = new XiaoMing();
		Father father = new Father();
		Mother mother = new Mother();
		public void driveCar() {
			this.father.driveCar();
		}
		public void cook() {
			this.mother.cook();
		}
		public void washDishes() {
			this.xiaoMing.washDishes();
		}
	}

这个时候，三个具体的类就组成一个子系统，封装类相当于门面角色，下面看我们的测试代码：

	Facade fac = new Facade();
	fac.driveCar();
	fac.cook();
	fac.washDishes();

输出结果：

> 小明的爸爸在开车<br/>
小明的妈妈在做饭<br/>
小明在洗碗

可以看到，客户端通过访问封装类来调用子系统内部类的方法。客户端并不知道随来执行该方法，只是知道子系统中有这个方法即可调用。

# 总结

------------------------

在外观模式中，所有的类都是对门面类的依赖，客户端只需要访问门面类即可，**避免了客户端对子系统内部类的直接调用。**尤其是在子系统内部类有很多的时候，如果不使用外观模式，客户端就要持有很多内部类的对象，会造成客户端代码很臃肿。
