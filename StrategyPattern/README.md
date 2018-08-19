# 介绍

--------------

策略模式属于行为型设计模式。它将各个算法封装起来，可以让调用者在运行时动态选择自己所需要的算法。首先来看一下它的定义：

> Define a family of algorithms, encapsulate each one, and make them interchangeable.<br/>
> 定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。

策略模式中，利用一个算法接口，让各个算法类实现该接口中的方法，来实现对算法的封装。调用算法的类需要持有该算法的对象，调用者的方法利用所持有算法对象中的方法来实现。

策略模式中需要有三种角色：

* Strategy抽象策略者。
它定义算法的方法，所有算法需要实现该接口中的方法，提供不同的解决方案。

* ConreteStrategy具体策略。
这是各个具体的算法，全都要实现抽象策略借口。

* Context封装角色。
也就是我们的算法调用者，可以根据不同的算法对象调用不同的算法。

# 例子

--------------------

如果小明和小红要去旅游，那么有三种方式可以选择——坐飞机、坐火车或是自驾游。如果不想直接就做决定，可以将这三种方式封装起来，想用什么方式再去决定。下面来看我们的代码：

首先，要有抽象策略类，也就是算法的通用接口：

	public interface Vehicle {
		public void travel();
	}

然后，是三个具体的策略类，就是三种交通方式：

坐飞机：

	public class Airplane implements Vehicle {
		@Override
		public void travel() {
			System.out.println("坐飞机去旅游...");
		}
	}

坐火车：

	public class Train implements Vehicle {
		@Override
		public void travel() {
			System.out.println("坐火车去旅游...");
		}
	}

自己开车：

	public class Car implements Vehicle {
		@Override
		public void travel() {
			System.out.println("自己开车去旅游...");
		}
	}

三种策略都搞定后，就是我们的调用者类了：

	public class Person {
		private Vehicle vehicle;
		public Person(Vehicle vehicle) {
			this.vehicle = vehicle;
		}
		public void travel() {
			this.vehicle.travel();
		}
	}

OK，现在三种角色都搞定了，接下来看我们的测试代码：

	System.out.println("小明去旅游---------------");
	Person xiaoMing = new Person(new Airplane());
	xiaoMing.travel();
	System.out.println("小红去旅游---------------");
	Person xiaoHong = new Person(new Train());
	xiaoHong.travel();

输出结果：

> 小明去旅游---------------<br/>
坐飞机去旅游...<br/>
小红去旅游---------------<br/>
坐火车去旅游...

可以看到，虽然小明和小红都是同一个类，然而旅游的方式却是可以自己选择的。这种动态绑定算法的方式就是策略模式。

# 总结

------------------------

策略模式是设计模式中较简单的一种，它的定义也很简单、清楚，仅仅利用了继承和多态机制。策略模式最大的优点就是**算法可以自由切换**，不被具体的类所固定；而且算法还可以继续扩展，如果再增加一个算法，那么不需要更改别的，直接实现算法接口就可以了，非常简单自由。

但是，策略模式也有其缺点，最大的缺陷就是，**调用者必须要知道有哪些具体策略类才能去调用**。这意味着所有的策略类都要对外暴露，这会带来很多不必要的风险。因此，该模式通常会与其他设计模式一起使用。