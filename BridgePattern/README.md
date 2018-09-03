# 介绍

---------------

桥接模式也叫桥梁模式，是一种结构型设计模式。主要目的是**实现类与类之间的解耦**。先来看一下它的定义：

> Decouple an abstraction from its implementation so that the two can vary independently.<br/>
> 将抽象和实现解耦，使得二者可以独立地变化。

桥接模式的目的还是很清楚的，就是为了解耦。而且该模式的实现也很简单，仅仅是利用了 Java 组合的性质就可以实现类的解耦功能，将抽象与实现分离开。

该模式充分利用了类与类之间的依赖关系，抽象类依赖实现类。在抽象类中调用所依赖类的方法，这样，抽象类和实现类就可以互不干扰了。

桥接模式主要包含四种角色：

* Abstraction——抽象化角色。
抽象类或接口，定义具体角色的行为，在抽象角色中显示声明需要依赖实现类。

* Implementor——实现化角色。
抽象类或接口，定义实现角色的行为。

* RefinedAbstraction——修正抽象化角色。
实现抽象角色的行为，在该行为中调用所依赖的实现类中的方法。

* ConcreteImplementor——具体实现化角色。
实现实现化角色，具体实现抽象类所需的行为，但实现过程与抽象类无关。 

# 例子

----------------

如果小明要出去吃午饭，有两种选择——吃面和吃饭。但是如果想将 `吃什么` 的实现，与抽象角色分开，就需要单独写一个出去吃的类，相当于这里的实现角色：

	public interface Lunch {
		public void eatLunch();
	}

两种具体的实现角色：

吃饭：

	public class RiceLunch implements Lunch {
		@Override
		public void eatLunch() {
			System.out.println("午饭吃饭...");	
		}
	}

吃面：

	public class NoodlesLunch implements Lunch {
		@Override
		public void eatLunch() {
			System.out.println("午饭吃面...");
		}
	}

抽象化角色，可以是一个接口或抽象类：

	public abstract class Person {
		private Lunch lunch;
		public Person(Lunch lunch) {
			this.lunch = lunch;
		}
		public void eatLunch() {
				this.lunch.eatLunch();
		}
		public Lunch getLunch() {
			return this.lunch;
		}
	}

具体的抽象角色，这里就相当于小明：

	public class XiaoMing extends Person {
		public XiaoMing(Lunch lunch) {
			super(lunch);
		}
		@Override
		public void eatLunch() {
			System.out.println("小明在吃午饭。");
			super.eatLunch();
		}
	}

最后就是测试代码了：

	public static void main(String[] args) {
		XiaoMing xiaoMing = new XiaoMing(new RiceLunch());
		xiaoMing.eatLunch();
	}

输出结果：

> 小明在吃午饭。<br/>
午饭吃饭...

可以看到，该模式与策略模式相当相似，原因就是二者都是以组合方式实现的。通过对不同的依赖可以有不同的实现，但是该模式不仅仅利用了组合，还利用了重写。在具体的抽象角色中重写抽象角色的方法，可以说是策略模式的一种升级版。

# 总结

-----------------

很多设计模式都用到了组合的方式来实现，像策略模式，桥接模式等等，但是实现的目的有所不同。不得不说，组合的应用场景还是很多的，相比于继承，在设计模式中，更推荐的就是组合方式，**能用组合的地方就尽量不要使用继承**。