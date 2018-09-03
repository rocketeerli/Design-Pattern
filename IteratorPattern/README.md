# 介绍

----------------

迭代器模式是一种行为型设计模式，它是我们经常使用的一个设计模式，但是基本上不会单独写一个迭代器，大都使用的是 Java 语言内置的迭代器。可以说这是一个融入 Java 语言的设计模式，不止 Java ，其他很多语言都会内置这个模式。下面来看它的定义：

> Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.<br/>
> 它提供一种方法访问一个容器对象中各个元素，而又不需要暴露该对象的内部细节。

迭代器模式是一个专门服务容器的设计模式。容器只需要负责增删元素即可，剩下的遍历操作交给迭代器就可以了。

迭代器模式主要有四个角色：

* Iterator——抽象迭代器。
抽象类或接口，定义迭代器的操作。

* ConcreteInterator——具体迭代器。
实现抽象迭代器，具体实现其中的各个操作。

* Aggregate——抽象容器。
抽象容器需要有一个可以返回迭代器的方法。

* ConcreteAggregate——具体容器。
实现抽象容器的方法，创建出容纳迭代器的对象。

# 模板

------------------

抽象迭代器：

	public interface Iterator {
		//遍历到下一个元素.
		public Object next();
		//是否已经遍历到尾部。
		public boolean hasNext();
		//删除当前指向的元素。
		public boolean remove();
	}

具体迭代器：

	public class ConcreteIterator implements Iterator {
		private Vector<Object> vector = new Vector<>();
		public int cursor = 0;
		public ConcreteIterator(Vector<Object> vector) {
			this.vector = vector;
		}
		@Override
		public boolean hasNext() {
			if (this.cursor == this.vector.size()) {
				return false;
			}
			return true;
		}
		@Override
		public Object next() {
			Object result = null;
			if (this.hasNext()) {
				result = this.vector.get(this.cursor++);
			} else {
				result = null;
			}
			return result;
		}
		@Override
		public boolean remove() {
			this.vector.remove(this.cursor);
			return true;
		}
	}

抽象容器：

	public interface Aggregate {
		public void add(Object object);
		public void remove(Object object);
		public Iterator iterator();
	}

具体容器：

	public class ConcreteAggregate implements Aggregate {
		private Vector<Object> vector = new Vector<>();
		@Override
		public void add(Object object) {
			this.vector.add(object);	
		}
		@Override
		public Iterator iterator() {
			return new ConcreteIterator(this.vector);
		}
		@Override
		public void remove(Object object) {
			this.remove(object);	
		}
	}

场景类：

	public class Client {
		public static void main(String[] args) {
			Aggregate aggregate = new ConcreteAggregate();
			aggregate.add("苹果");
			aggregate.add("橘子");
			aggregate.add("香蕉");
			Iterator iterator = aggregate.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}

输出结果：

> 苹果<br/>
橘子<br/>
香蕉

# 总结

------------------

简单地说，**迭代器就像一个容器的游标一样，可以遍历容器内部的所有元素**。

如果没有语言内置的迭代器，迭代器模式还是挺困难的一个设计模式，但是，由于大部分语言已经含有了这个模式，因此，该模式基本不会单独出现，我们应该尽量使用语言内置的迭代器，避免自己重新搭建。