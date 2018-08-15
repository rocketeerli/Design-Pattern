# 介绍


----------

模板方法模式属于行为类设计模式，该模式仅仅是使用了面向对象的继承特性，将实现类共有的方法抽取出来放到抽象类中，这样就避免了相同代码多次出现的情况，是代码复用的最简单的方式，下面先来看一下它的定义：

> Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm`s structure.  <br/>
> 定义一个操作中的算法框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

简单地说，该模式就是**将子类中共有的方法放到父类中。**

# 例子


----------

该模式主要是继承机制，这里我们举一个去餐馆吃饭的例子：

有两个人（小红和小明）去吃饭，首先定义这两个人的抽象类：

	public abstract class Person {
		//主食。
		protected abstract void eatSonething();
		//饮料。
		protected abstract void drinkSomthing();
		//开餐。
		public abstract void eat();
	}


小红的定义如下：


	public class PersonHong extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一碗面条!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一杯果汁!!! ");	
		}
		@Override
		public void eat() {
			eatSonething();
			drinkSomthing();
		}
	}

小明的定义如下：

	public class PersonMing extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一份盖饭!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一瓶雪碧!!! ");
		}
		@Override
		public void eat() {
			eatSonething();
			drinkSomthing();
		}
	}
客户端调用：

	Person xiaoHong = new PersonHong();
	Person xiaoMing = new PersonMing();
	System.out.println("小红点餐-----------");
	xiaoHong.eat();
	System.out.println("小明点餐-----------");
	xiaoMing.eat();

输出结果：

> 小红点餐-----------<br>
一碗面条!!! <br>
一杯果汁!!! <br>
小明点餐-----------<br>
一份盖饭!!! <br>
一瓶雪碧!!! 


这里我们会发现，小红和小明的行为中都有 `eat()` 方法，这时我们就很容易地想到使用继承机制，将 `eat()` 方法放到 `Person` 类中：

	public abstract class Person {
		//主食。
		protected abstract void eatSonething();
		//饮料。
		protected abstract void drinkSomthing();
		//开餐。
		public final void eat() {
			eatSonething();
			drinkSomthing();
		}
	}

小红：

	public class PersonHong extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一碗面条!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一杯果汁!!! ");	
		}
	}

小明：

	public class PersonMing extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一份盖饭!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一瓶雪碧!!! ");
		}
	}

这样，就已经无意识地使用了我们今天讲的模板方法模式。是不是很惊讶，没错，模板方法模式就是这么简单，仅仅只是 Java 的继承应用而已，几乎所有的项目都会使用它。

这里有两点需要注意：

* **抽象模板中的方法尽可能地使用 `protected` 进行修饰，符合迪米特法则。**
* **模板方法要加上 `final` 修饰词，防止子类对其进行重写。**

当然，模板方法模式也可以稍作扩展，下面是利用钩子函数进行扩展的一种形式。

# 钩子函数扩展


----------

模板方法可以对其进行扩展，在通常的情况下，我们子类是实现父类，并不能影响父类的行为，然而使用钩子函数，我们可以让子类影响父类的行为。

例如，一般在每次点餐前都需要一包餐巾纸，那么在 `Person` 类中就需要增加选餐巾纸的行为（ `getPaper()` ）,但是小明并不需要，这样我们就需要增加一个 `boolean` 类型属性，用来判断是否需要餐巾纸，修改抽象类如下：

	public abstract class Person {
		protected boolean needPaper = true;
		//主食。
		protected abstract void eatSonething();
		//饮料。
		protected abstract void drinkSomthing();
		//餐巾纸。
		private void paper() {
			System.out.println("需要餐巾纸!!! ");
		}
		//开餐。
		public final void eat() {
			this.eatSonething();
			this.drinkSomthing();
			if (needPaper) {
				paper();
			}
		}
	}
同样的，小明和小红也需要做相应的更改：

小红：

	public class PersonHong extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一碗面条!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一杯果汁!!! ");	
		}
		public void setNeedPaper(boolean needPaper) {
			this.needPaper = needPaper;
		}
	}

小明：

	public class PersonMing extends Person {
		@Override
		protected void eatSonething() {
			System.out.println("一份盖饭!!! ");
		}
		@Override
		protected void drinkSomthing() {
			System.out.println("一瓶雪碧!!! ");
		}
		public void setNeedPaper(boolean needPaper) {
			this.needPaper = needPaper;
		}
	}

客户端代码设置是否需要餐巾纸：

	PersonHong xiaoHong = new PersonHong();
	PersonMing xiaoMing = new PersonMing();
	System.out.println("小红点餐-----------");
	xiaoHong.eat();
	System.out.println("小明点餐-----------");
	xiaoMing.setNeedPaper(false);
	xiaoMing.eat();
输出：

> 小红点餐-----------<br/>
一碗面条!!! <br/>
一杯果汁!!! <br/>
需要餐巾纸!!! <br>
小明点餐-----------<br/>
一份盖饭!!! <br>
一瓶雪碧!!! 

这样的话，我们就可以通过更改子类进而影响父类中的行为，虽然父类中的行为会随子类而改变，然而行为的框架却是没有变，符合模板方法模式的定义。

# 总结


----------
模板方法模式是一种很基础的行为类设计模式，我们都很熟悉它，只不过不知道它就是模板方法模式而已。可以说，这个设计模式很接地气，并没有多么高大上。

<br/>
