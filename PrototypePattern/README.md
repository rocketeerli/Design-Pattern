# 介绍

----------

原型模式属于创建型设计模式，它为对象提供了一种新的创建方式——使用 `clone()` 方法。通过该方法对对象进行拷贝。被拷贝的对象需要实现 `Cloneable` 接口，该接口中没有任何方法，实现该接口仅仅是告诉 `Java` 这个对象是可能被拷贝的，并不表示可以被拷贝。如果要表示可以被拷贝，还需要重写 `Object` 类中的 `clone()` 方法，重写之后，就可以使用 `clone()` 方法进行对象的创建了。

该模式的定义如下：

> Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. <br/>
> 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

意思就和上面说的一样，就不过多解释了。

使用原型模式有两点好处：

* 性能优良。原型模式是在内存二进制流的拷贝，要比直接 `new` 一个对象性能好很多。
* 没有构造函数的约束。由于拷贝直接在内存中进行，因此并不执行构造函数。

# 例子

----------
如果现在有一个苹果类：

	public class Apple implements {
		public void say() {
			System.out.println("我是苹果...");
		}
	}

当我们在客户端要新建一个苹果对象时，往往使用的是： `Apple apple = new Apple()` 。然而，使用原型模式，就可以使用另外一种方式。演示之前，需要将苹果类进行改造：

	public class Apple implements Cloneable {
		public void say() {
			System.out.println("我是苹果...");
		}
		@Override
		public Apple clone() {
			Apple apple = null;
			try {
				apple = (Apple)super.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("拷贝失败!!!");
			}
			return apple;
		}
	}

在实现了 `Cloneable` 接口并重写 `clone()` 方法后，就可以使用原型模式了。客户端测试代码如下：

	Apple apple1 = new Apple();
	apple1.say();
	Apple apple2 = apple1.clone();
	apple2.say();

输出：

> 我是苹果...<br/>
我是苹果...

可以看到第二个苹果并没有使用 `new` 方式创建，而是直接由第一个苹果拷贝过来，这种创建对象的方式就是原型模式。

# 总结

----------

原型模式算是一种十分简单的设计模式，因此用途也十分广泛。一般是与其他设计模式结合起来使用，例如，与工厂模式结合使用，内部使用 `clone()` 方法，然后由工厂方法提供给调用者使用。此外，原型模式在创建大量对象时，特别适用。
