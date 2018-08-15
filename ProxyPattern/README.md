# 介绍


----------

代理模式属于结构型设计模式。从名字就可以看出它的功能，——**给对象设置代理。 ** 就像明星拥有经纪人一样，对象也是需要“经纪人”的。 介绍它之前，我们先来看一下它的定义：

> Provide a surrogate or placeholder for another object to control access to it.<br/>
> 为其他对象提供一种代理以控制对这个对象的访问。

通俗地讲，就是并不想让程序直接访问这个对象，从而给这个对象设置了一个代理，设置代理有很多好处，最直接的就是可以帮助对象**过滤掉一些无意义的访问。**

代理模式主要包括三种角色：

 1. 抽象角色。负责定义代理角色和真实角色的框架。
 2. 真实角色。被代理的角色，实现抽象角色，代理者调用它的方法。
 3. 代理角色。实现抽象角色，调用者通过它调用真实角色的方法。

下面就详细介绍一下代理模式。

# 普通代理模式


----------

想象一个场景，如果有一天开车去聚餐，吃饭的时候喝酒了，酒后不能驾车，但是车又不能扔在这，那么这时候就需要找一个代驾帮你开车。这时，代驾就是代理者，他帮你开车，开的不是他的车，还是你的车，这就是代理模式。下面看代码实现：

首先有一个抽象类，都有 `driveCar()` 行为：

	public abstract class Driver {
		public abstract void driveCar();
	}

然后你和代驾都需要实现这个抽象类：

你：

	public class CarOwner extends Driver {
		@Override
		public void driveCar() {
			System.out.println("开车回家...");	
		}
	}

代驾：

	public class ProxyDriver extends Driver {
		private Driver drunkDriver;
		public ProxyDriver(Driver drunkDriver) {
			this.drunkDriver = drunkDriver;
		}
		@Override
		public void driveCar() {
			this.drunkDriver.driveCar();
		}
	}

这样的话，将你和代驾联系起来，代驾就可以调用你的方法，开你的车了，客户端测试代码如下：

	Driver you = new CarOwner();
	ProxyDriver proxyDriver = new ProxyDriver(you);
	proxyDriver.driveCar();

输出：

> 开车回家...


可以看到，这里我并没有直接调用 `你` 的开车方法，而是通过代驾开 `你` 的车。这就是代理模式。

# 强制代理模式


----------

普通的代理模式是通过代理去调用真实对象的方法，而强制代理就是说，真实的对象不能直接访问。要想访问必须使用代理，否则拒绝访问。这和醉酒开车是一样的，醉酒后肯定是不能开车的，如果非要开车，那么必须叫代驾，让代驾帮你开车。如果没有代驾，那么就是不能开车，这就是强制代理模式。

当然，也不是随便找一个会开车的就可以帮你开车了，必须是你叫的代驾，也就是你指定的，那么在这里就需要你自己去指定一个代理了。先看代码：

首先还是 `Driver` 抽象类：

	public abstract class Driver {
		public abstract void driveCar();
		public abstract Driver getProxy();
	}

你和代驾分别实现它：

你：

	public class CarOwner extends Driver {
		private Driver proxyDriver = null;
		@Override
		public void driveCar() {
			if (proxyDriver == null ) {
				System.out.println("无代驾或代驾不是指定的，不能开车...");
			} else {
				System.out.println("开车回家...");
			}	
		}
		@Override
		public Driver getProxy() {
			this.proxyDriver = new ProxyDriver(this);
			return this.proxyDriver;
		}
	}

代驾：

	public class ProxyDriver extends Driver {
		private Driver drunkDriver;
		public ProxyDriver(Driver drunkDriver) {
			this.drunkDriver = drunkDriver;
		}
		@Override
		public void driveCar() {
			this.drunkDriver.driveCar();
		}
		//代理类的代理，暂时设为它自己。
		@Override
		public Driver getProxy() {
			return this;
		}
	}

三种角色都有了，先来测试一下：

	Driver you = new CarOwner();
	you.driveCar();

输出：

> 无代驾或代驾不是指定的，不能开车...


出问题了，很容易就会发现，客户端没有设置代理，并不能开车，那么再设置代理：

	Driver you = new CarOwner();
	ProxyDriver proxyDriver = new ProxyDriver(you);
	proxyDriver.driveCar();

输出：

> 无代驾或代驾不是指定的，不能开车...

发现还是不行，仔细检查，发现原来不是我们指定的代理开的车，那么就需要你去指定特定的代驾，重写测试代码如下：

	Driver you = new CarOwner();
	Driver proxy = you.getProxy();
	proxy.driveCar();
运行结果：

> 开车回家...

这回终于可以开车回家了。

可以看到，强制代理模式中，代理与真实对象间的联系更强。

# 总结


----------

代理模式也是很基础的一种设计模式，只要是实现接口或是继承抽象类的对象，都能设置代理，适用范围非常广。

当然，代理模式除了这两种扩展之外，还有动态代理模式（例如，`AOP` ），属于代理模式的高级进化版，由于涉及的东西较多，以后有机会再跟大家分享。