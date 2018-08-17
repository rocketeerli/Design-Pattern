# 设计模式

##

# 设计模式六大原则——SOLID

设计模式的六大原则有：

* Single Responsibility Principle：单一职责原则
* Open Closed Principle：开闭原则
* Liskov Substitution Principle：里氏替换原则
* Law of Demeter：迪米特法则
* Interface Segregation Principle：接口隔离原则
* Dependence Inversion Principle：依赖倒置原则

把这六个原则的首字母联合起来（ `L` 算做一个）就是 `SOLID` （solid，稳定的），其代表的含义就是这六个原则结合使用的好处：**建立稳定、灵活、健壮的设计**

## 单例模式

单例模式是设计模式当中十分常见的一种。它是用来干嘛的呢？简单地说，当某个类创建的对象在整个程序中只有一个时，就可以使用它。

主要包括：

* 懒汉式
* 饿汉式
* 静态内部类
* 双重校验锁

## 装饰器模式

装饰器模式是一种属于结构型的设计模式，它通过一层一层地包装类方式来为类增加新的方法，本质是利用组合，同时也利用了继承。与单纯的继承相比，它更加灵活，因为装饰类之间可以动态地自由组合来添加功能。

装饰器模式是创建一个装饰类来实现接口中的方法，然后利用这个装饰类的各个子类用来装饰实现该接口的各个不同的类。

## 工厂方法模式

工厂模式属于创建类设计模式中非常基础的一种，对于它的定义是这样的：

> Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
 <br>
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

这么说的可能太官方，通俗地讲，工厂模式就是将创建对象的事情交给一个工厂类，客户端想要创建对象的时候，只需要调用工厂类中的方法就能实例化一个类，而不用使用 `A a = new A()` 的方式创建。

工厂模式一般是用来创建复杂对象采用的一种方式，因为简单对象就可以直接使用 `new` 的方式创建。当然，是否使用还是要视具体情况而定。

两种常见的扩展模式：

* 静态工厂模式（简单工厂模式）
* 多工厂模式

## 抽象工厂模式

抽象工厂模式是工厂方法模式的升级版，当实现类非常多的时候，而且实现类之间关系复杂的时候，只利用一个工厂创建所有的实现类显然是不可能的，那么该如何创建呢？这就需要创建工厂的工厂类了，也就是我们的抽象工厂模式。

抽象工厂模式的定义是这样的：

> Provide an interface for creating families of related or dependent objects without specifying their concrete classes.<br/>
> 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类。

抽象工厂模式与工厂模式最大的区别就是 **抽象工厂相当于对工厂方法做了一层的封装。** 抽象工厂模式中的工厂类创建具体类的工厂，然后由这些工厂去创建实现类。相当于多个工厂方法的组合，然而，不同的是，这些创建的工厂类之间是有联系的并不是随意地组合在一起的。

## 模板方法模式


模板方法模式属于行为类设计模式，该模式仅仅是使用了面向对象的继承特性，将实现类共有的方法抽取出来放到抽象类中，这样就避免了相同代码多次出现的情况，是代码复用的最简单的方式，下面先来看一下它的定义：

> Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm`s structure.  <br/>
> 定义一个操作中的算法框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

简单地说，该模式就是**将子类中共有的方法放到父类中。**

有两点需要注意：

* **抽象模板中的方法尽可能地使用 `protected` 进行修饰，符合迪米特法则。**
* **模板方法要加上 `final` 修饰词，防止子类对其进行重写。**

## 建造者模式

建造者模式属于创建型模式中较高级的一种模式，它一般是在创建由其他简单对象组成的复杂对象时使用，将创建时的构建细节和表示分离开。一般是将组成对象的各个部分按一定的顺序组合在一起，然后创建对象。定义如下：

> Separate the construction of a complex object from its representation so that the same construction process can create different representations. <br/>
> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

简单地说，该模式适用于**创建由不同组合的简单对象构成的复杂对象。** 或是 **相同方法，不同执行顺序的一组对象。**

举例之前，首先需要说明一下使用建造者模式需要的几个部分：

 1. 产品类（Product）：包括我们的复杂对象及其组成部分。
 2. 抽象建造者（Builder）：用于规范产品的组建，由子类实现。
 3. 具体建造者（ConcreteBuilder）：实现抽象建造者的方法，并且返回一个具体产品，最终的产品就是由它创建。
 4. 导演类（Director）：负责调用具体建造者，用它来创建各种不同组合的产品，并利用它开放更具体的创建方法给客户端。


## 代理模式

代理模式属于结构型设计模式。从名字就可以看出它的功能，——**给对象设置代理。 ** 就像明星拥有经纪人一样，对象也是需要“经纪人”的。 介绍它之前，我们先来看一下它的定义：

> Provide a surrogate or placeholder for another object to control access to it.<br/>
> 为其他对象提供一种代理以控制对这个对象的访问。

通俗地讲，就是并不想让程序直接访问这个对象，从而给这个对象设置了一个代理，设置代理有很多好处，最直接的就是可以帮助对象**过滤掉一些无意义的访问。**

代理模式主要包括三种角色：

 1. 抽象角色。负责定义代理角色和真实角色的框架。
 2. 真实角色。被代理的角色，实现抽象角色，代理者调用它的方法。
 3. 代理角色。实现抽象角色，调用者通过它调用真实角色的方法。

## 原型模式

原型模式属于创建型设计模式，它为对象提供了一种新的创建方式——使用 `clone()` 方法。通过该方法对对象进行拷贝。被拷贝的对象需要实现 `Cloneable` 接口，该接口中没有任何方法，实现该接口仅仅是告诉 `Java` 这个对象是可能被拷贝的，并不表示可以被拷贝。如果要表示可以被拷贝，还需要重写 `Object` 类中的 `clone()` 方法，重写之后，就可以使用 `clone()` 方法进行对象的创建了。

该模式的定义如下：

> Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. <br/>
> 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

意思就和上面说的一样，就不过多解释了。

使用原型模式有两点好处：

 1. 性能优良。原型模式是在内存二进制流的拷贝，要比直接 `new` 一个对象性能好很多。
 2. 没有构造函数的约束。由于拷贝直接在内存中进行，因此并不执行构造函数。


## 中介者模式

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

## 命令模式

命令模式是一种行为型设计模式，它是降低类之间耦合度的一种方式。命令模式中，将每个具体操作封装成一个个命令，调用者只需要发出特定的命令即可实现相应的功能。各个命令类会自动找到实现这个功能的对象并调用它们的方法。下面先来看一下命令模式的定义：

> Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.<br/>
> 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

一般而言，一个命令会涉及到多个对象，为了避免调用者依赖这么多对象，命令模式将各种命令封装好后交给调用者，命令内部高内聚，外部低耦合，非常符合设计模式的原则。

命令模式一般包含三种角色：

* Receive接收者。命令类调用各个接收者的方法来执行相应的命令，接收者是命令的执行者。
* Command命令类。将调用者需要使用的命令封装好就是命令类，底层实现是调用各个接收者的方法。
* Invoker调用者。调用者负责接收命令，命令发布者只和调用者进行通信，不依赖其他对象，将命令传给调用者，调用者负责执行。


## 责任链模式

责任链模式是一种行为型设计模式，该模式是降低请求者和处理者之间耦合度的解决方案。一个请求者可能对应多个处理者，不同的请求也需要不同的处理者去处理，但是一个请求者如果要持有多个处理者的对象，耦合度未免太高了。而责任链模式就是解决这种问题的。首先看一下它的定义：

> Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it. <br/>
> 十多个对象都有机会处理请求，从而避免了请求者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

简而言之，责任链模式就是**将各个处理者连成一条链**，我们只需要将请求者的请求传入到链的顶端，然后请求就会沿着链一直传下去，直到找到可以处理该请求的处理者，处理者就可以正常处理请求了。可以说，责任链模式最核心的就是**“链”**。

责任链模式主要包括四种角色：

 1. 抽象处理者（Handler）。约束各个处理者，并为它们提供统一的框架。
 2. 具体处理着（ConcreteHandler）。具体处理请求的对象。
 3. 抽象请求者（Request）。统一请求者的方法，并设置请求级别。
 4. 具体请求者（ConcreteRequest）。提出具体请求的对象。

