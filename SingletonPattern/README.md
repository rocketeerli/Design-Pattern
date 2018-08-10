# 介绍

----------


单例模式是设计模式当中十分常见的一种。它是用来干嘛的呢？简单地说，当某个类创建的对象在整个程序中只有一个时，就可以使用它。

在单例模式中，类的构造器是私有的，即你不能通过调用这个类的构造器来创建该类的实例。
<br>

# 作用

 --- 

那么你可能会问，单例模式用于解决什么问题呢？创建的对象保证只有一个，有什么用呢？如果你认为没用那就大错特错了。

###  节省运行资源

最直接的作用，就是当程序中出现频繁地创建和删除某个对象且该对象在程序中最多只能有一个的时候，就可以利用单例模式，这样可以大大节省程序运行消耗的资源。

### 避免文件多重访问

除此之外，在代码中进行文件操作的时候，程序中要保证文件不能重复打开，否则就会出现一些意想不到的bug（如程序自动创建其他文件）。这个时候，我们就可以利用单例模式，让这个文件的实例在程序中只有一个，从而避免了访问的冲突。

### 其他
单例模式的思想就是保证只有一个对象的实例，然而其书写方式还是有很多种的，下面来看一下一些基本的单例模式的书写方式。
<br>

# 懒汉式

--- 

懒汉式的最突出的特点就是它很懒，什么意思呢，就是该对象的实例只有在被需要的时候才进行创建，而不是一开始声明的时候就创建。




最简单的懒汉式写法如下：

	public class Singleton {
		private static Singleton singleton;
	
		private Singleton() {}
	
		public static Singleton getInstance() {
			if (singleton == null) {
				singleton = new Singleton();
			}
			return singleton;
		}
	}


可以看到，在这里，`singleton` 在声明的时候并没有给它一个初始值，而是在 `getInstance()` 方法中进行判断，为空后才创建，这就是懒汉式。

然而这种写法并不是线程安全的，因为如果两个线程同时到达 `singleton == null` 的判断时，就会各自创建一个实例，这样就得到了两个实例，这就违反了单例模式的规约。

因此，可以增加一个锁机制来保证线程安全：

	public class Singleton {
		private static Singleton singleton;

		private Singleton() {
		}
	
		public static synchronized Singleton getInstance() {
			if (singleton == null) {
				singleton = new Singleton();
			}
			return singleton;
		}
	}

这样就可以保证线程安全了。
<br>

# 饿汉式

----------


饿汉式是与懒汉式相对应的，即无论程序需不需要用该实例，在声明的时候，我先 'new' 出来一个，最直接的写法如下：

	public class Singleton {
		private static Singleton singleton = new Singleton();
		private Singleton() {}
	
		public static Singleton getInstance() {
			return singleton;
		}
	}


这样写的话，在 `getInstance()` 方法中就不需要对 `singleton` 是否为空进行判断了，直接返回已经创建好的实例就可以了。因此，也就不存在线程安全问题了。
<br>

# 静态内部类


----------


顾名思义，就是在这个类中，再创建一个静态的内部类。类的属性是私有的，且利用 `final` 修饰，表明不可变，即引用只能指向这一个位置，从而也达到了只有一个实例的效果。

代码如下：

	public class Singleton {  
		private static class SingletonHolder {  
	   		private static final Singleton INSTANCE = new Singleton();  
		}  
		private Singleton (){}  
		public static final Singleton getInstance() {  
			return SingletonHolder.INSTANCE;  
		}  
	}

可以看到，`getInstance()` 返回这个内部类中的不可变的数据类型。
<br>

# 双重校验锁

----------

双重校验锁也是用来保证线程安全的一种方式，具体方式请看代码：


	// 双重校验锁
	public class Singleton {  
		private volatile static Singleton singleton;  
		private Singleton (){}  
		public static Singleton getSingleton() {  
		if (singleton == null) {  
			synchronized (Singleton.class) {  
				if (singleton == null) {  
					singleton = new Singleton();  
				}  
		    }  
		}  
		return singleton;  
		}  
	}


在这里，不仅使用了 `volatile` 修饰词，还对 `Singleton.class` 上了锁，从而达到保证线程安全的效果。
<br>

# 总结

----------

单例模式总是跟线程安全有关系，因此使用时需要注意。

对于单例模式，最简单也是最常用的两种方式还是懒汉式和饿汉式，而且这两种方式也更易于理解。一般没有其他特殊需求，这两种方式已经可以满足大部分项目的需求了。
<br>
<br>

