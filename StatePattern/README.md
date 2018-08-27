# 介绍

----------------

状态模式是一种行为型设计模式。当**对象在不同状态下有不同行为时**使用，在该模式中，我们将对象的不同状态
定义成不同的类，在这些状态类下有它们各自的行为，然后利用环境类使客户端在调用时，**不需要显示地去设置状态之间的转换**。下面先来看一下它的定义：

> Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.<br/>
> 当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。

该模式的本质是**状态的改变引起行为的改变**，从外部看就像该对象所对应的类发生了改变一样。例如，像电灯开关，在灯的不同状态下（亮或灭），按下开关时，灯的行为是不一样的。或者说汽车，只有在车停下的时候才能打开车门，行驶的时候是不可以开门的。这就是状态的不同导致行为的不同。

该模式主要有三种角色：

* State——抽象状态角色。
负责定义各个状态的行为，该抽象状态包含所有具体状态的方法。并且包含环境角色，帮助切换状态。

* ConcreteState——具体状态角色。
实现具体状态下可以执行的行为（不能执行的行为自动切换状态或不做处理）。通常来讲，**有多少行为就会产生多少状态。**

* Context——环境角色。
该角色是客户端要调用的接口，负责具体状态的切换（客户端不知道状态的切换）。

例子

------------------

现在有一扇门，有开和关两种方法，对应的也有开和关两种状态，不同状态下的行为是不一样的，如果在开门状态下，就不应该有开门的方法。因此这个例子就是典型的状态模式。

首先就是状态的抽象类：

	public abstract class State {
		protected Context context;
		public void setContext(Context context) {
			this.context = context;
		}
		public abstract void open();
		public abstract void close();
	}

然后是具体的状态：

开门状态：

	public class OpenState extends State {
		@Override
		public void open() {
			//不能再次打开门。
			System.out.println("门已经是开着的了。");
		}
		@Override
		public void close() {
			System.out.println("门关上了");		
		}
	}

关门状态：

	public class CloseState extends State {
		@Override
		public void open() {
			System.out.println("门打开了");
		}
		@Override
		public void close() {
			//不能重复关门。
			System.out.println("门已经是关上的了。");
		}
	}

然后是我们的的环境类：

	public class Context {
		public final static State OPENSTATE = new OpenState();
		public final static State CLOSESTATE = new CloseState();
		private State currentState = CLOSESTATE;
		public void open() {
			this.currentState.open();
			this.currentState = OPENSTATE;
		}
		public void close() {
			this.currentState.close();
			this.currentState = CLOSESTATE;
		}
	}

OK，现在三种角色已经定义好，下面来看一下客户端如何调用：

	Context context = new Context();
	context.close();
	context.open();
	context.close();

输出结果：

> 门已经是关上的了。<br/>
门打开了<br/>
门关上了

可以看到，在客户端代码中，我们只需要调用环境角色的方法即可，并不需要手动去改变状态，**每执行一次方法就可以自动改变对象的状态**，进而可以产生不同的行为，这就是状态模式。

# 总结

----------------------------

在状态模式中，所有的状态都是一个子类，如果修改状态，只需要修改这个状态的子类即可，但是增加状态不仅要增加子类，还要增加状态中的方法。状态模式最大的优点就是**外界调用不知道内部的状态改变**，只要调用其方法即可。

然而状态模式也有其缺陷之处：由于所有的状态都是一个类，有的对象可能会有非常多的状态，这个时候就使用状态模式就会导致类特别多，不利于维护。