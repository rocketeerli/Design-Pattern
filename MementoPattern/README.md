# 介绍

-----------------

备忘录模式是一种行为型设计模式。它可以保存一个对象的状态，在需要的时候对其进行恢复，相当于键盘上的 `ctrl + z`。 下面先看一下它的定义：

> Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.<br/>
> 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态了。

简单地说，备忘录模式就是一种**可以让程序状态倒退**的一种方式,就像传说中的“反悔药”一样。该模式利用特定的类对需要“反悔”的类进行状态存储，在需要的时候再对其进行恢复。

备忘录模式主要包含三种角色：

* Originator发起人角色。
这是我们需要备份状态的角色，备忘录中存储的是该角色以前的状态，在需要的时候可以恢复。

* Memento备忘录角色。
该角色存储发起人角色的状态。

* Caretaker备忘录管理员角色。
该角色是发起人角色和备忘录角色之间的桥梁，负责管理备忘录。

# 例子

------------------

我们假设小明的心情是小明的一个状态，我们的程序要设计成在需要的时候，小明能够恢复之前的“心情”状态。

首先，要有一个小明类，相当于发起人角色：

	public class XiaoMing {
		private String state = "";
		public String getState() {
			return this.state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public Memento createMemento() {
			return new Memento(this.state);
		}
		public void restoreMemento(Memento memento) {
			this.setState(memento.getState());
		}
	}

然后是存储小明状态的备忘录：

	public class Memento {
		private String state = "";
		public Memento(String state) {
			this.state = state;
		}
		public String getState() {
			return this.state;
		}
		public void setState(String state) {
			this.state = state;
		}
	}

最后是备忘录管理者：

	public class Caretaker {
		private Memento mem;
		public Memento getMemento() {
			return this.mem;
		}
		public void setMemento(Memento memento) {
			this.mem = memento;
		}
	}

三种角色定义好后就是我们的测试代码了：

	XiaoMing xiaoMing = new XiaoMing();
	xiaoMing.setState("高兴");
	System.out.println("小明现在的状态是：" + xiaoMing.getState());
	Caretaker caretaker = new Caretaker();
	caretaker.setMemento(xiaoMing.createMemento());
	xiaoMing.setState("伤心");
	System.out.println("小明现在的状态是：" + xiaoMing.getState());
	xiaoMing.restoreMemento(caretaker.getMemento());
	System.out.println("小明现在的状态是：" + xiaoMing.getState());

输出结果：

> 小明现在的状态是：高兴<br/>
小明现在的状态是：伤心<br/>
小明现在的状态是：高兴

可以看到，小明的状态恢复到之前的“高兴”状态了。客户端代码中并没有使用备忘录这个类，而是利用备忘录管理者在备忘录和发起人之间进行通信。这就是该模式的**在对象之外保存这个状态**。


# 总结

------------------

上面介绍的仅仅是非常简单的备忘录模式，然而在具体的项目中很少能之间套用上面的模式，通常都需要进行较大的扩展和改变来适应具体的环境，例如多个状态需要回复等等。这里我们先不对其进行讨论。