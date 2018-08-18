# 介绍

----------------

适配器模式是一种结构型设计模式。该模式的主要功能是将一个类与另一个类的接口匹配起来，使得这两个类最后都实现同一个接口。先来看一下它的定义：

> Convert the interface of a clss into another interface clients expect. Adapter lets classes work together that couldn`t otherwise because of incompatible interfaces.<br/>
> 将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

通俗地讲，适配器就像变压器一样，将电压变为电器能够使用的电压。一般而言，该模式适用于项目完成后的修改时使用，仅用于修改，因此，在写项目的时候要尽量避免使用该模式。

适配器模式主要包含三种角色：

* Target目标角色 
该角色决定将另一个类转换为何种接口。

* Adaptee源角色
不匹配的类，我们需要把这个类通过加一个适配器转换成一个新的类，实现目标角色的接口。

* Adapter适配器角色
适配器，相当于我们的变压器角色，负责连接目标角色和源角色，该角色是适配器模式的核心。

适配器模式主要包括两种：类适配器和对象适配器。本质区别是类适配器是类间的继承，而对象适配器是对象的合成关系。下面分别介绍这两种适配器。

# 类适配器

-----------------

类适配器就是使用继承来实现两个类之间的适配的，先来看一下例子。

现在开发一个项目，有一个鸟类的接口：

	public interface Bird {
		public void fly();
	}

其中有一个实现类——燕子：

	public class Swallow implements Bird {
		@Override
		public void fly() {
			System.out.println("燕子在飞....");
		}
	}

然而现在项目要和另一个项目合并，那个项目中也有一个鸟类——大雁：

	public class WildGoose {
		public void wildGooseFly() {
			System.out.println("大雁在飞...");
		}
	}

按理说我们是要把二者合并起来的，然而这两个类中的方法并不一样，虽然都是实现了 `飞行` 的方法，但是方法名不同。然而两个项目都已经上线，并不能随便改，那这个时候就需要我们的适配器了。

我们的适配器样子如下：

	public class Adapter extends WildGoose implements Bird {
		@Override
		public void fly() {
			super.wildGooseFly();
		}
	}

OK，这样的话，所有的角色就都定义好了。下面来进行测试：

	Bird swallow = new Swallow();
	swallow.fly();
	Bird wildGoose = new Adapter();
	wildGoose.fly();

输出结果：

> 燕子在飞....<br/>
大雁在飞...


可以看到，这样大雁类和燕子类就统一起来了，二者相当于实现了同样的接口。这是类适配器模式，可以看到，该模式中的适配器是采用继承机制实现的。

# 对象适配器

-----------------

对象适配器是在适配器中持有要匹配类的对象，还是上面的鸟类，具体操作如下：

鸟类和大雁类是不变的，接口还是那个接口，源角色也不发生任何改变，那么就只能修改适配器了，下面看我们的适配器在不使用继承的情况下怎么实现：

适配器：

	public class Adapter implements Bird {
		WildGoose wildGoose = new WildGoose();
		@Override
		public void fly() {
			wildGoose.wildGooseFly();
		}
	}

测试代码：

	Bird swallow = new Swallow();
	swallow.fly();
	Bird wildGoose = new Adapter();
	wildGoose.fly();

输出结果：

> 燕子在飞....<br/>
大雁在飞...

可以看到，这次适配器并没有使用继承，然而它在类中存储了一个源角色的对象，所有调用的方法都有源角色来执行，这就是对象适配器。


# 总结

-----------------

两种适配器模式都是将不能使用的类包装一层，从而实现API的统一。然而在具体项目中，由于只能继承一个父类，且类适配器只能通过重写父类中的方法进行扩展，相对而言不灵活，而对象适配器就很灵活，因此通常而言，对象适配器使用的场景较多。