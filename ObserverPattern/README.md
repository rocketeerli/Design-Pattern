# 介绍

-------------------

观察者模式是一种行为型设计模式，也叫做发布订阅模式（Publish/subcribe）。**当一个对象发生改变时，多个对象需要得到通知**，这个时候就需要利用观察者模式来实现。先看一下它的定义：

> Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. <br/>
> 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态时，则所有依赖于它的对象都会得到通知并被自动更新。

定义已经说得很明白了，甚至如何实现的都写得很清楚。这是一种**一对多的关系**，多个对象要去监视一个对象，实现的方式是利用依赖关系，这就是观察者模式。

观察者模式定义了四种角色：

* Subject 抽象被观察者。
定义被观察者的方法和属性，包括增加、删除和通知观察者的方法。

* Observer 抽象观察者。
定义观察者的通用方法，一般是收到被观察者的信息后要执行的方法。

* ConcreteSubject 具体被观察者。
实现被观察者自己的行为。

* ConcreteObserver 具体观察者。
具体实现抽象观察者中的方法。


# 例子

---------------

如果小明父母出去上班，小明需要自己在家中。然而小明父母并不放心小明，因此要对小明进行监视，小明做什么他父母都要知道。这就是典型的观察者模式，这里小明父母是观察者，小明是被观察者。

首先是抽象的观察者和被观察者：

抽象观察者：

	public interface Observer {
		public void see(String context);
	}

抽象被观察者：


	public abstract class Subject {
		private List<Observer> observerList = new ArrayList<>();
		//增加观察者。
		public void addObserver(Observer observer) {
			this.observerList.add(observer);
		}
		//删除观察者。
		public void deleteObserver(Observer observer) {
			this.observerList.remove(observer);
		}
		//通知所有的观察者。
		public void notifyObservers(String context) {
			for (Observer observer : observerList) {
				observer.see(context);
			}
		}
	}

然后是具体的被观察者，这里就是小明：

	public class XiaoMing extends Subject {
		public void eat() {
			System.out.println("我是小明，我在吃饭");
			super.notifyObservers("小明在吃饭");
		}
		public void doHomework() {
			System.out.println("我是小明,我在写作业");
			super.notifyObservers("小明在写作业");
		}
	}

最后一种角色是具体的观察者，也就是小明的父母：

父亲：

	public class Father implements Observer {
		@Override
		public void see(String context) {
			System.out.println("小明的爸爸收到消息：" + context);
		}
	}

母亲：

	public class Mother implements Observer {
		@Override
		public void see(String context) {
			System.out.println("小明的妈妈收到消息：" + context);
		}
	}

好了现在四种角色都已经定义好了，下面看我们的测试代码：

	XiaoMing xiaoMing = new XiaoMing();
	Observer father = new Father();
	Observer mother = new Mother();
	xiaoMing.addObserver(mother);
	xiaoMing.addObserver(father);
	xiaoMing.eat();
	xiaoMing.doHomework();

输出结果：

> 我是小明，我在吃饭<br/>
小明的妈妈收到消息：小明在吃饭<br/>
小明的爸爸收到消息：小明在吃饭<br/>
我是小明,我在写作业<br/>
小明的妈妈收到消息：小明在写作业<br/>
小明的爸爸收到消息：小明在写作业

这里，可以看到，无论小明做什么，他父母都会知道，这就是观察者模式。

# 总结 

---------------------

观察者模式在项目中应用十分广泛，它最大的优点就是**增加观察者或是增加被观察者都很方便**，可以直接增加。此外，利用它进行触发机制的实现也是很方便的。当然，也有其缺点，由于通知是顺序进行通知的，当一个观察者卡顿时，其他后所有的都会停止，当然，可以利用多线程的思想来解决，这里就不是我们要讨论的了。