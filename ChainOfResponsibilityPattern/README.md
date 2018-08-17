# 介绍

-----------------

责任链模式是一种行为型设计模式，该模式是降低请求者和处理者之间耦合度的解决方案。一个请求者可能对应多个处理者，不同的请求也需要不同的处理者去处理，但是一个请求者如果要持有多个处理者的对象，耦合度未免太高了。而责任链模式就是解决这种问题的。首先看一下它的定义：

> Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it. <br/>
> 十多个对象都有机会处理请求，从而避免了请求者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

简而言之，责任链模式就是**将各个处理者连成一条链**，我们只需要将请求者的请求传入到链的顶端，然后请求就会沿着链一直传下去，直到找到可以处理该请求的处理者，处理者就可以正常处理请求了。可以说，责任链模式最核心的就是**“链”**。

责任链模式主要包括四种角色：

 1. 抽象处理者（Handler）。约束各个处理者，并为它们提供统一的框架。
 2. 具体处理着（ConcreteHandler）。具体处理请求的对象。
 3. 抽象请求者（Request）。统一请求者的方法，并设置请求级别。
 4. 具体请求者（ConcreteRequest）。提出具体请求的对象。


# 例子

-------------------

在学校有一个学生提出请求的时候，要先找辅导员询问；如果辅导员处理不了，就把这个请求提交到院长那里；如果院长也处理不了，那么就要把请求提交到校长那里去。这样，总有一个处理者会处理该请求。这就是典型的责任链模式。那么代码该如何实现呢。

首先，需要定义我们的抽象处理者：

	public abstract class Handler {
		private int level;
		private Handler nextHandler = null;
		public Handler(int level) {
			this.level = level;
		}
		public void HandleMessage(Request request) {
			if (this.level == request.getLevel()) {
				this.response(request);
			} else if (this.nextHandler != null) {      //传给下一级处理者。
				this.nextHandler.HandleMessage(request);
			} else {
				System.out.println("无法处理该学生的请求...");
			}
		}
		public void setNext(Handler handler) {
			this.nextHandler = handler;
		}
		protected abstract void response(Request request);
	}

然后是具体处理人：

辅导员：

	public class Counsellor extends Handler {
		public Counsellor(int level) {
			super(level);
		}
		@Override
		protected void response(Request request) {
			System.out.println("学生的请求是：");
			System.out.println(request.getRequest());
			System.out.println("导员同意了该学生的请求...");
		}
	}

院长：

	public class Dean extends Handler {
		public Dean(int level) {
			super(level);
		}
		@Override
		protected void response(Request request) {
			System.out.println("学生的请求是：");
			System.out.println(request.getRequest());
			System.out.println("院长同意了该学生的请求...");
		}
	}


校长：

	public class President extends Handler {
		public President(int level) {
			super(level);
		}
		@Override
		protected void response(Request request) {
			System.out.println("学生的请求是：");
			System.out.println(request.getRequest());
			System.out.println("校长同意了该学生的请求...");
		}
	}

然后是抽象请求者：

	public abstract class Request {
		private int level;
		private String request;
		public Request(int level, String request) {
			this.level = level;
			this.request = request;
		}
		public int getLevel() {
			return this.level;
		}
		public String getRequest() {
			return this.request;
		}
	}

最后是请求者，也就是我们的学生：

	public class Student extends Request {
		public Student(int level, String request) {
			super(level, request);
		}
	}

OK，四种角色定义好了，下面看我们的测试代码：

	Handler president = new President(1);
	Handler dean = new Dean(2);
	Handler counsellor = new Counsellor(3);
	counsellor.setNext(dean);
	dean.setNext(president);
	counsellor.HandleMessage(new Student(3, "我要换寝室..."));
	System.out.println("：------------------------");
	counsellor.HandleMessage(new Student(1, "我要转学..."));
输出结果：

> 学生的请求是：<br/>
我要换寝室...<br/>
导员同意了该学生的请求...<br/>
:------------------------<br/>
学生的请求是：<br/>
我要转学...<br/>
校长同意了该学生的请求...

这样，导员是处理者链的顶端，无论什么级别的请求，只要交给导员就可以了，就算导员处理不了也会交给链上的下一个处理者。这样，最后请求一定会被处理的。

# 总结

------------------------

责任链模式是处理请求者和处理者关系的一个非常好的设计方案。最大的优点就是将请求和处理分开。请求者可以不用知道是谁处理的，处理者也不需要知道是谁请求的，两个对象各自实现自己的功能，实现了二者耦合度的问题。

但是，责任链模式还是有他的缺点的。最大的缺点就是：如果处理者过多，就会导致这条责任链很长很长，那处理一条命令就会花费很长时间，不利于项目的运行。因此，在利用此模式的时候，需要注意处理者的数目。