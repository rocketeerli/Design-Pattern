# 介绍

-----------------------

访问者模式是一种行为型设计模式，该模式的核心是**访问者根据不同的具体类执行不同的方法**。这里的具体类一般是一个容器内的不同类，例如，一个公司下的不同职员。所有的具体类都要实现接收访问者访问的方法，然后访问者根据传进来的具体类来判断执行那个方法。先看一下访问者模式的定义：

> Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.<br/>
> 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新操作。

简而言之，就是访问者去访问不同的具体类，然后具体类将自己作为参数传给访问者，访问者再根据这些不同的具体类来实现不同的方法，这样，通过**在访问者中添加具体类的新方法**，从而达到**既给元素添加新操作，又不破坏元素结构**的效果。

定义里的某种数据结构就相当于一个大容器，各元素就是容器内部的不同类。有容器就会有遍历，由于是不同的类，因此遍历不能使用简单的迭代器，需要专门写一个类来服务。因此该模式不仅有元素类和访问者类，还要有结构对象，用来遍历或是生成容器内的元素。

访问者模式中主要包含五种角色：

* Visitor——抽象访问者。
在该抽象类（或接口）中定义访问者可以访问哪些元素。 `visit()` 方法中的不同参数决定了可以访问的具体元素。

* ConcreteVisitor——具体访问者。
实现抽象访问者中的抽象方法，根据 `visit()` 方法的不同参数来决定添加的“新操作”。

* Element——抽象元素。
定义 `accept()` 方法，用来接受访问者。其参数决定了哪一个访问者可以访问。

* ConcreteElement——具体元素。
实现抽象元素中的方法，并将自身作为参数传给访问者中的方法。

* ObjectStruture——结构对象。
就像上面所说，用来遍历或是生成容器内的元素。

# 例子

------------------------

想象一些你要“访问”你的文具盒，文具盒就相当于容器，其中的不同物品就相当于具体元素，你作为访问者根据拿到不同物品来决定添加什么操作。代码如下：

首先定义抽象元素和抽象访问者：

抽象元素：

	public abstract class Element {
		public abstract void getName();
		public abstract void accept(Visitor visitor);
	}

抽象访问者：

	public abstract class Visitor {
		public abstract void visit(Pencil pencil);
		public abstract void visit(Eraser eraser);
	}

然后定义具体元素：

铅笔类：

	public class Pencil extends Element {
		@Override
		public void getName() {
			System.out.println("铅笔");
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}
	}

橡皮类：

	public class Eraser extends Element {
		@Override
		public void getName() {
			System.out.println("橡皮");
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}
	}

访问者根据不同的具体元素来执行不同的操作：

	public class ConcreteVisitor extends Visitor {
		@Override
		public void visit(Pencil pencil) {
			pencil.getName();
			System.out.println("拿到了铅笔");
		}
		@Override
		public void visit(Eraser eraser) {
			eraser.getName();
			System.out.println("拿到了橡皮");
		}
	}

最后是我们的生产类：

	public class ObjectStruture {
		public static Element createElement() {
			Random random = new Random();
			if (random.nextInt(100) > 50) {
				return new Pencil();
			} else {
				return new Eraser();
			}
		}
	}

OK，现在为止，五种角色都已经定义好了，接下来看我们的测试代码：

	public static void main(String[] args) {
		for (int i = 0; i < 5;i++) {
			Element element = ObjectStruture.createElement();
			element.accept(new ConcreteVisitor());
		}
	}

输出结果：

> 铅笔<br/>
拿到了铅笔<br/>
铅笔<br/>
拿到了铅笔<br/>
橡皮<br/>
拿到了橡皮<br/>
橡皮<br/>
拿到了橡皮<br/>
铅笔<br/>
拿到了铅笔

虽然这里的访问者只有一个，但是也可以看到，即使传入了相同的访问者，也可以对各个不同的具体元素添加新操作。如果还需要添加其他新的操作，还可以再创建其他的访问者，直接实现抽象访问者即可。

# 总结

------------------------

访问者模式的扩展性很好，如果要继续增加新的操作，在 `Visitor` 类中添加方法或直接增加新的访问者类都可以。但如果要新增加一个具体的元素，就会相当麻烦，因此该模式不适合数据结构经常改变的项目。

访问者模式最大的缺点就是**不符合依赖倒置原则**，可以看到，访问者类依赖具体的元素类来实现添加不同的操作。这与依赖倒置原则中的依赖抽象不依赖具体相违背。