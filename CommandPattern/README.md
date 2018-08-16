# 介绍

-----------

命令模式是一种行为型设计模式，它是降低类之间耦合度的一种方式。命令模式中，将每个具体操作封装成一个个命令，调用者只需要发出特定的命令即可实现相应的功能。各个命令类会自动找到实现这个功能的对象并调用它们的方法。下面先来看一下命令模式的定义：

> Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.<br/>
> 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

一般而言，一个命令会涉及到多个对象，为了避免调用者依赖这么多对象，命令模式将各种命令封装好后交给调用者，命令内部高内聚，外部低耦合，非常符合设计模式的原则。

命令模式一般包含三种角色：

* Receive接收者。命令类调用各个接收者的方法来执行相应的命令，接收者是命令的执行者。
* Command命令类。将调用者需要使用的命令封装好就是命令类，底层实现是调用各个接收者的方法。
* Invoker调用者。调用者负责接收命令，命令发布者只和调用者进行通信，不依赖其他对象，将命令传给调用者，调用者负责执行。

# 例子

-----------

如果我现在要让一只小猫和一只小狗执行一些特定的命令，我并不直接对小猫和小狗说，而是将命令传给调用者，由调用者去执行。下面看一下具体代码实现：

抽象命令接收者：

	public abstract class Receiver {
		public abstract void walk();
		public abstract void sit();
	}

具体命令接收者就是小猫和小狗。

小猫：

	public class Cat extends Receiver {
		@Override
		public void walk() {
			System.out.println("猫在走...");
		}
		@Override
		public void sit() {
			System.out.println("猫坐下了...");
		}
	}

小狗：

	public class Dog extends Receiver {
		@Override
		public void walk() {
			System.out.println("狗在走...");
		}
		@Override
		public void sit() {
			System.out.println("狗坐下了...");
		}
	}

命令接收者定义好后，就是命令类了。

抽象命令类：

	public abstract class Command {
		protected Receiver receiver1;
		protected Receiver receiver2;
		public abstract void execute();
		public void setReceiver(Receiver receiver1, Receiver receiver2) {
			this.receiver1 = receiver1;
			this.receiver2 = receiver2;
		}
	}

具体命令类：

走：

	public class WalkCommand extends Command {
		@Override
		public void execute() {
			super.receiver1.walk();
			super.receiver2.walk();
		}
	}
	
坐下：

	public class SitCommand extends Command {
		@Override
		public void execute() {
			super.receiver1.sit();
			super.receiver2.sit();
		}
	}

最后是我们的调用者：

	public class Invoker {
		private Command com;
		
		public void setCommand(Command com) {
			this.com = com;
		}
		
		public void action() {
			this.com.execute();
		}
	}

OK，现在三大角色已经定义好了，最后测试一下：


	//命令调用者。
	Invoker invoker = new Invoker();
	//命令执行者（猫和狗）。
	Receiver cat = new Cat();
	Receiver dog = new Dog();
	//命令。
	System.out.println("开始走------------");
	Command walkCommand = new WalkCommand();
	walkCommand.setReceiver(cat, dog);
	invoker.setCommand(walkCommand);
	invoker.action();
			
	System.out.println("都坐下------------");
	Command sitCommand = new SitCommand();
	sitCommand.setReceiver(cat, dog);
	invoker.setCommand(sitCommand);
	invoker.action();

结果：

> 开始走------------<br/>
猫在走...<br/>
狗在走...<br/>
都坐下------------<br/>
猫坐下了...<br/>
狗坐下了...

可以看到，新建两个命令给调用者，调用者直接执行，客户端代码很简洁，可以看出命令模式的高内聚特点。另外，在具体情况中，命令中的 `Receiver` 并不都在抽象类中，很多都是由具体命令而定，这里放在抽象类中属于特殊情况。

# 总结

-----------
命令模式使得类之间的耦合度降低，这样就使得命令非常容易扩展，有新的命令直接实现抽象命令类就可以了，不需要更多的更改。

需要注意的是，命令模式最大的问题就是有多少个命令就需要有多少个具体命令类，因此，当命令特别多的时候，代码会变得相当臃肿。
