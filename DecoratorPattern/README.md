
# 介绍

---
给对象添加方法的方式有多种，通常，当说到给对象添加方法时，最直接的就是直接在该对象的类中增加新的方法，但这样在最上方增加方法，不仅更改了原来的代码结构，还会让代码看起来十分臃肿；然后，我们就能想到继承，直接新增加一个类来继承，在子类中添加方法，然而这样做并不够灵活，而且在不断增加方法时，还会出现多重继承的现象，导致代码结构很乱；那么，这时候就需要另一种方式了，这种方式就是组合的方式。关于组合，是委托的一种，具体信息可以点击[这里](https://blog.csdn.net/seriousplus/article/details/80462722)。



# 概念

---
装饰器模式是一种属于结构型的设计模式，它通过一层一层地包装类方式来为类增加新的方法，本质是利用组合，同时也利用了继承。与单纯的继承相比，它更加灵活，因为装饰类之间可以动态地自由组合来添加功能。

装饰器模式是创建一个装饰类来实现接口中的方法，然后利用这个装饰类的各个子类用来装饰实现该接口的各个不同的类。具体介绍请参考下面的例子。


# 例子

---
现在有一个Person接口：

	public interface Person {
		public void talk();
	}

</textarea>

有一个GoodPerson类实现了该接口：

	public class GoodPerson implements Person{
		public GoodPerson() {}
		@Override
		public void talk() {
			System.out.println("I am a good person");
		}
	}
如果不使用继承的方式，在GoodPerson类中如何增加新的方法呢。可以利用组合的方式，使用其他类对其进行包装：

那么，首先就需要创建一个抽象的装饰类：


	public abstract class AbstractPerson implements Person {
		protected final Person person;
		public AbstractPerson(Person person) {
			this.person = person;
		}
		@Override
		public void talk() {
			person.talk();
		}
	}

然后，我们创建三个这个装饰类的子类，用于为上面接口的实体类进行装饰：

首先，是一个Father类：


	public class Father extends AbstractPerson implements Person {
		public Father(Person person) {
			super(person);
		}
		@Override
		public void talk() {
			super.talk();
			talkOtherThing();
		}
		public void talkOtherThing() {
			System.out.println("I am a father");
		}
	}

然后，是Student类：

	public class Student extends AbstractPerson implements Person{
		public Student(Person person) {
			super(person);
		}
		@Override
		public void talk() {
			super.talk();
			talkOtherThing();
		}
		public void talkOtherThing() {
			System.out.println("I am a student");
		}
	}
可能这个人也是老师，因此，再创建一个Teacher类：


	public class Teacher extends AbstractPerson implements Person {
		public Teacher(Person person) {
			super(person);
		}
		@Override
		public void talk() {
			super.talk();
			talkOtherThing();
		}
		public void talkOtherThing() {
			System.out.println("I am a teacher");
		}
	}

在这三个装饰类的子类中，都添加了新的方法，是利用继承实现的。还差组合，我们的目的是给Person类添加方法，那就少不了组合。

可能很多人看到这里不知道创建了这么多类，但确不知道咋装饰的，不急，请看一下我的测试代码：


	public class Test {
		public static void main(String[] args) {
			Father father = new Father(new Teacher(new Student(new GoodPerson())));
			father.talk();
		}
	}

可以看到，装饰类通过层层嵌套，将一个Person类进行了功能的扩展，运行一下，输出的结果为：


	I am a good person
	I am a student
	I am a teacher
	I am a father


这样，我就将一个好人添加了三种生活中的角色（父亲，学生和老师），如果只有老师一种角色，那么只需要一层嵌套即可。

可以看到，这几个装饰类可以自由组合，甚至还可以进行递归地嵌套，是不是很方便，很灵活

# 总结

---
所以，可以说装饰器模式是个递归的设计，多个装饰类的子类可以相互嵌套，实现多次装饰的功能。但无论装饰多少次，被装饰者永远都是装饰器类的子类型。