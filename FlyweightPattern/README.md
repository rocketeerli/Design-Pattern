# 介绍

----------------

享元模式是一种结构型设计模式。该模式主要是**通过将对象的粒度细分，从而减少创建大量对象所占的内存**。下面先来看一下它的定义：

> Use sharing to support large numbers of fine-grained objects efficiently.<br/>
> 使用共享对象可有效地支持大量的细粒度的对象。

享元模式将一个对象分为**内部状态**和**外部状态**。所谓内部状态，就是各个对象可以共享的信息；相应的，外部状态就是不可以共享的状态，是随外界依赖变化而变化。内部状态和外部状态彼此互不影响，改变其中一个并不会改变另一个的行为。

享元模式通过将对象的内部状态和外部状态区分开来，从而实现相似对象大量创建的内存优化功能。

享元模式主要包含四种角色：

* Flyweight——抽象享元角色。
定义对象的内部状态和外部状态及其对应的方法。

* ConcreteFlyweight——具体享元角色。
实现抽象享元角色的方法，在具体的角色中，实现具体方法时需要注意将内部状态与外部状态区分开，不应出现二者同时被修改的方法。

* unshareConcreteFlyweight——不可共享的享元角色。
该角色是不能使用共享技术的对象，一般在讨论线程安全时使用。

* FlyweightFactory——享元工厂。
类似于工厂模式的工厂，该工厂存储所有的对象，需要创建对象时，如果已经创建，直接取出即可；否则，新建对象。

# 例子

-------------------

现在，有一个铅笔厂，可以生产不同型号的铅笔（HB、2B...）。如果要生产很多铅笔，那么就会导致对象类型特别多，造成内存资源的浪费。因此，我们可以按照类型划分种类，内存中每种类型的铅笔只有一个，这样就可以节约内存资源了。

那么该怎么做呢，首先要把对象的内部状态和外部状态分开，先看我们的抽象享元类：

	public abstract class Pen {
		//内部状态
		private int length;
		//外部状态
		protected final String penType;
		//享元角色必须接受外部状态，且不能更改。
		public Pen(String penType) {
			this.penType = penType;
		}
		//根据外部状态做出的操作。
		public abstract void introduce();
		//内部状态的操作。
		public int getLength() {
			return this.length;
		}
		public void setLength(int length) {
			this.length = length;
		}
	}

然后看我们的具体享元类，也就是铅笔类：

	public class Pencil extends Pen {
		public Pencil(String penType) {
			super(penType);
			System.out.println("生产了一根" + penType + "型号的铅笔");
		}
		@Override
		public void introduce() {
			System.out.println("我是铅笔，我的类型是：" + this.penType);
		}
	}

最后就是我们的享元工厂，利用一个“池”来存储所有对象：

	public class FlyweightFactory {
		public static HashMap<String, Pen> pool = new HashMap<>();
		public static Pen getPen(String penType) {
			Pen pen = null;
			if (pool.containsKey(penType)) {
				pen = pool.get(penType);
			} else {
				pen = new Pencil(penType);
				pool.put(penType, pen);
			}
			return pen;
		}
	}

最后就是我们客户端的测试了：

	public static void main(String[] args) {
		Pen pen1 = FlyweightFactory.getPen("HB");
		pen1.introduce();
		Pen pen2 = FlyweightFactory.getPen("2B");
		pen2.introduce();
		Pen pen4 = FlyweightFactory.getPen("4B");
			pen4.introduce();
		
		Pen pen5 = FlyweightFactory.getPen("2B");
		pen5.introduce();
		Pen pen6 = FlyweightFactory.getPen("4B");
		pen6.introduce();
	}

输出结果：

> 生产了一根HB型号的铅笔<br/>
我是铅笔，我的类型是：HB<br/>
生产了一根2B型号的铅笔<br/>
我是铅笔，我的类型是：2B<br/>
生产了一根4B型号的铅笔<br/>
我是铅笔，我的类型是：4B<br/>
我是铅笔，我的类型是：2B<br/>
我是铅笔，我的类型是：4B

可以看到，如果内存中已经有该类型的铅笔了，就不需要创建新的了，直接拿出来用就可以了，在创建大量对象时，这样可以减少很多内存占用。

# 总结

------------------

享元模式是根据一个特定的外部信息来存储对象的，内存中每种类型的对象只有一个。但是，在多线程程序中，由于在享元工厂中判断对象是否存在时，利用的是 `if-else` 判断语句，因此**很可能会导致线程安全问题**，使用时需要注意。当然也可以对该模式进行扩展从而避免出现线程安全问题。