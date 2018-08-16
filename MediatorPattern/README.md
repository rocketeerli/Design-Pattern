# 介绍

---------

中介者模式是一种行为型设计模式，它是降低类与类之间高度耦合性的有效方式。一般在多个类之间有紧密联系的时候使用。先来看一下它的定义：

> Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.<br/>
> 用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

总的来说，就是在多个类之间彼此联系紧密的时候，为了降低耦合度，创建一个中介者，将对象之间的联系都放到中介者里。这样，各个类只需要完成自己那部分任务即可。

中介类一般包含四种角色：

* 抽象中介者（Mediator）。用来定义中介者的统一接口。
* 具体中介者（Concrete Mediator）。通过调用各个同事类的方法来协调工作。
* 抽象同事类（AbstractColleague）。同事类需要实现这个接口，共用一个中介者。
* 同事类（Colleague）。同事类中主要有两种方法，一种是需要依赖其他对象才能完成的方法，这种方法通过调用中介者来实现。另外一种就是不需要依赖其他对象，自己就能实现的方法。

需要说明的是，类与类之间的通信是必然的，一般只有在两个以上的类之间联系紧密的时候，才使用中介者模式。否则，频繁使用中介者模式会导致项目中中介者类太多，降低可维护性。

# 例子

---------

如果小明去北京工作，需要租一个房子，找房主就需要中介，中介将小明和房主联系起来后，小明就需要跟房主进行一系列的交易，但是双方又不想频繁联系，那么这个时候还是需要这个中介者来进行中间的交易。

首先，定义抽象的中介者：

	public abstract class AbstractMediator {
		protected Renter renter;
		protected HouseOwner houseOwner;
		
		public void setRenter(Renter renter) {
			this.renter = renter;
		}
		
		public Renter getRenter() {
			return renter;
		}
		
		public void setHouseOwner(HouseOwner houseOwner) {
			this.houseOwner = houseOwner;
		}
		
		//收房租。
		public abstract void getRent();
		//交房租。
		public abstract void giveRent();
	}

然后是抽象的同事类：

	public abstract class AbstractColleague {
		protected AbstractMediator mediator;
		public AbstractColleague(AbstractMediator mediator) {
			this.mediator = mediator;
		}
	}
	

具体的中介者：

	public class ConcreteMediator extends AbstractMediator {
		@Override
		public void getRent() {
			super.renter.giveRent();
		}
		@Override
		public void giveRent() {
			super.houseOwner.getRent();
		}
	}

小明，需要交房租，并让房主收钱：

	public class Renter extends AbstractColleague {
		public Renter(AbstractMediator mediator) {
			super(mediator);
			mediator.setRenter(this);
		}
		//交房租。
		public void giveRent() {
			System.out.println("已交房租...");
		}
	
		//提醒房主收房租。
		public void huoseOwnerReceive() {
			super.mediator.giveRent();
		}
	}

房主，负责收钱，并让小明交房租：

	public class HouseOwner extends AbstractColleague {
		public HouseOwner(AbstractMediator mediator) {
			super(mediator);
			mediator.setHouseOwner(this);
		}
		//收房租。
		public void getRent() {
			System.out.println("已收到房租...");
		}
		//交房租。
		public void requireRent() {
			super.mediator.getRent();
		}
	}

OK，四种角色都定义好了，我们来测试一下：

	//定义中介。
	AbstractMediator mediator = new ConcreteMediator();
	//小明和房主。
	Renter xiaoMing = new Renter(mediator);
	HouseOwner houseOwner = new HouseOwner(mediator);
	//小明交房费。
	xiaoMing.giveRent();
	xiaoMing.huoseOwnerReceive();

结果：

> 已交房租...<br/>
已收到房租...

可以看到，小明没有依赖房主也能让房主收钱。小明通过中介者让房主收钱，房主也是通过中介者来让小明交房租，这就是中介者的作用。如果没有中介者，二者之间需要互相持有彼此的对象，然后进行交易。在多个类的情况下，这样做的耦合度会很高。

# 总结

----------

中介者模式能够有效地降低类与类之间的耦合度，然而，如果有很多类之间联系密切，那么中介者需要调度的类就会很多，这样的话会导致中介者很臃肿，这也是中介者模式最大的缺点，使用时需要注意。

