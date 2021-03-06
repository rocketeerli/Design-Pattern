# [设计模式六大原则——SOLID](https://blog.csdn.net/rocketeerLi/article/details/81585705)

设计模式的六大原则有：

* Single Responsibility Principle：**单一职责原则**
一个类只负责一个职责。

* Open Closed Principle：**开闭原则**
一个软件实体，如类、模块和函数应该对扩展开放，对修改关闭。

* Liskov Substitution Principle：**里氏替换原则**
所有引用基类的地方必须能透明地使用其子类的对象。

* Law of Demeter：**迪米特法则**
一个对象应该对其他对象有最少的了解。

* Interface Segregation Principle：**接口隔离原则**
类间的依赖关系应该建立在最小的接口上。

* Dependence Inversion Principle：**依赖倒置原则**
高层模块不应该依赖底层模块，两者都应该依赖其抽象。抽象不应该依赖细节。细节应该依赖抽象。要尽可能使用接口或抽象类。

把这六个原则的首字母联合起来（ `L` 算做一个）就是 `SOLID` （solid，稳定的），其代表的含义就是这六个原则结合使用的好处：**建立稳定、灵活、健壮的设计**

## [工厂方法模式](https://blog.csdn.net/rocketeerLi/article/details/81669879)

工厂模式属于创建类设计模式中非常基础的一种，对于它的定义是这样的：

> Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
 <br>
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

这么说的可能太官方，通俗地讲，工厂模式就是将创建对象的事情交给一个工厂类，客户端想要创建对象的时候，只需要调用工厂类中的方法就能实例化一个类，而不用使用 `A a = new A()` 的方式创建。

工厂模式一般是用来创建复杂对象采用的一种方式，因为简单对象就可以直接使用 `new` 的方式创建。当然，是否使用还是要视具体情况而定。

两种常见的扩展模式：

* 静态工厂模式（简单工厂模式）
* 多工厂模式

## [抽象工厂模式](https://blog.csdn.net/rocketeerLi/article/details/81675073)

抽象工厂模式是工厂方法模式的升级版，当实现类非常多的时候，而且实现类之间关系复杂的时候，只利用一个工厂创建所有的实现类显然是不可能的，那么该如何创建呢？这就需要创建工厂的工厂类了，也就是我们的抽象工厂模式。

抽象工厂模式的定义是这样的：

> Provide an interface for creating families of related or dependent objects without specifying their concrete classes.<br/>
> 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类。

抽象工厂模式与工厂模式最大的区别就是 **抽象工厂相当于对工厂方法做了一层的封装。** 抽象工厂模式中的工厂类创建具体类的工厂，然后由这些工厂去创建实现类。相当于多个工厂方法的组合，然而，不同的是，这些创建的工厂类之间是有联系的并不是随意地组合在一起的。

## [模板方法模式](https://blog.csdn.net/rocketeerLi/article/details/81707841)


模板方法模式属于行为类设计模式，该模式仅仅是使用了面向对象的继承特性，将实现类共有的方法抽取出来放到抽象类中，这样就避免了相同代码多次出现的情况，是代码复用的最简单的方式，下面先来看一下它的定义：

> Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm`s structure.  <br/>
> 定义一个操作中的算法框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

简单地说，该模式就是**将子类中共有的方法放到父类中。**

有两点需要注意：

* **抽象模板中的方法尽可能地使用 `protected` 进行修饰，符合迪米特法则。**
* **模板方法要加上 `final` 修饰词，防止子类对其进行重写。**

## [建造者模式](https://blog.csdn.net/rocketeerLi/article/details/81708121)

建造者模式属于创建型模式中较高级的一种模式，它一般是在创建由其他简单对象组成的复杂对象时使用，将创建时的构建细节和表示分离开。一般是将组成对象的各个部分按一定的顺序组合在一起，然后创建对象。定义如下：

> Separate the construction of a complex object from its representation so that the same construction process can create different representations. <br/>
> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

简单地说，该模式适用于**创建由不同组合的简单对象构成的复杂对象。** 或是 **相同方法，不同执行顺序的一组对象。**

举例之前，首先需要说明一下使用建造者模式需要的几个部分：

 1. 产品类（Product）：包括我们的复杂对象及其组成部分。
 2. 抽象建造者（Builder）：用于规范产品的组建，由子类实现。
 3. 具体建造者（ConcreteBuilder）：实现抽象建造者的方法，并且返回一个具体产品，最终的产品就是由它创建。
 4. 导演类（Director）：负责调用具体建造者，用它来创建各种不同组合的产品，并利用它开放更具体的创建方法给客户端。


## [单例模式](https://blog.csdn.net/rocketeerLi/article/details/81562863)

单例模式是设计模式当中十分常见的一种。它是用来干嘛的呢？简单地说，当某个类创建的对象在整个程序中只有一个时，就可以使用它。

主要包括：

* 懒汉式
* 饿汉式
* 静态内部类
* 双重校验锁

## [装饰器模式](https://blog.csdn.net/rocketeerLi/article/details/81562806)

装饰器模式是一种属于结构型的设计模式，它通过一层一层地包装类方式来为类增加新的方法，本质是利用组合，同时也利用了继承。与单纯的继承相比，它更加灵活，因为装饰类之间可以动态地自由组合来添加功能。

装饰器模式是创建一个装饰类来实现接口中的方法，然后利用这个装饰类的各个子类用来装饰实现该接口的各个不同的类。

可以说装饰器模式是个递归的设计，多个装饰类的子类可以相互嵌套，实现多次装饰的功能。但无论装饰多少次，被装饰者永远都是装饰器类的子类型。


## [代理模式](https://blog.csdn.net/rocketeerLi/article/details/81708233)

代理模式属于结构型设计模式。从名字就可以看出它的功能，——**给对象设置代理。 ** 就像明星拥有经纪人一样，对象也是需要“经纪人”的。 介绍它之前，我们先来看一下它的定义：

> Provide a surrogate or placeholder for another object to control access to it.<br/>
> 为其他对象提供一种代理以控制对这个对象的访问。

通俗地讲，就是并不想让程序直接访问这个对象，从而给这个对象设置了一个代理，设置代理有很多好处，最直接的就是可以帮助对象**过滤掉一些无意义的访问。**

代理模式主要包括三种角色：

 1. 抽象角色。负责定义代理角色和真实角色的框架。
 2. 真实角色。被代理的角色，实现抽象角色，代理者调用它的方法。
 3. 代理角色。实现抽象角色，调用者通过它调用真实角色的方法。

## [原型模式](https://blog.csdn.net/rocketeerLi/article/details/81745034)

原型模式属于创建型设计模式，它为对象提供了一种新的创建方式——使用 `clone()` 方法。通过该方法对对象进行拷贝。被拷贝的对象需要实现 `Cloneable` 接口，该接口中没有任何方法，实现该接口仅仅是告诉 `Java` 这个对象是可能被拷贝的，并不表示可以被拷贝。如果要表示可以被拷贝，还需要重写 `Object` 类中的 `clone()` 方法，重写之后，就可以使用 `clone()` 方法进行对象的创建了。

该模式的定义如下：

> Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. <br/>
> 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

意思就和上面说的一样，就不过多解释了。

使用原型模式有两点好处：

 1. 性能优良。原型模式是在内存二进制流的拷贝，要比直接 `new` 一个对象性能好很多。
 2. 没有构造函数的约束。由于拷贝直接在内存中进行，因此并不执行构造函数。


## [中介者模式](https://blog.csdn.net/rocketeerLi/article/details/81750836)

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

## [命令模式](https://blog.csdn.net/rocketeerLi/article/details/81751311)

命令模式是一种行为型设计模式，它是降低类之间耦合度的一种方式。命令模式中，将每个具体操作封装成一个个命令，调用者只需要发出特定的命令即可实现相应的功能。各个命令类会自动找到实现这个功能的对象并调用它们的方法。下面先来看一下命令模式的定义：

> Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.<br/>
> 将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

一般而言，一个命令会涉及到多个对象，为了避免调用者依赖这么多对象，命令模式将各种命令封装好后交给调用者，命令内部高内聚，外部低耦合，非常符合设计模式的原则。

命令模式一般包含三种角色：

* Receive接收者。命令类调用各个接收者的方法来执行相应的命令，接收者是命令的执行者。
* Command命令类。将调用者需要使用的命令封装好就是命令类，底层实现是调用各个接收者的方法。
* Invoker调用者。调用者负责接收命令，命令发布者只和调用者进行通信，不依赖其他对象，将命令传给调用者，调用者负责执行。


## [责任链模式](https://blog.csdn.net/rocketeerLi/article/details/81783786)

责任链模式是一种行为型设计模式，该模式是降低请求者和处理者之间耦合度的解决方案。一个请求者可能对应多个处理者，不同的请求也需要不同的处理者去处理，但是一个请求者如果要持有多个处理者的对象，耦合度未免太高了。而责任链模式就是解决这种问题的。首先看一下它的定义：

> Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it. <br/>
> 十多个对象都有机会处理请求，从而避免了请求者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

简而言之，责任链模式就是**将各个处理者连成一条链**，我们只需要将请求者的请求传入到链的顶端，然后请求就会沿着链一直传下去，直到找到可以处理该请求的处理者，处理者就可以正常处理请求了。可以说，责任链模式最核心的就是**“链”**。

责任链模式主要包括四种角色：

 1. 抽象处理者（Handler）。约束各个处理者，并为它们提供统一的框架。
 2. 具体处理着（ConcreteHandler）。具体处理请求的对象。
 3. 抽象请求者（Request）。统一请求者的方法，并设置请求级别。
 4. 具体请求者（ConcreteRequest）。提出具体请求的对象。4


## [适配器模式](https://blog.csdn.net/rocketeerLi/article/details/81813239)

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

适配器模式主要包括两种：类适配器和对象适配器。本质区别是类适配器是类间的继承，而对象适配器是对象的合成关系。

## [策略模式](https://blog.csdn.net/rocketeerLi/article/details/81836991)

策略模式属于行为型设计模式。它将各个算法封装起来，可以让调用者在运行时动态选择自己所需要的算法。首先来看一下它的定义：

> Define a family of algorithms, encapsulate each one, and make them interchangeable.<br/>
> 定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。

策略模式中，利用一个算法接口，让各个算法类实现该接口中的方法，来实现对算法的封装。调用算法的类需要持有该算法的对象，调用者的方法利用所持有算法对象中的方法来实现。

策略模式中需要有三种角色：

* Strategy抽象策略者。
它定义算法的方法，所有算法需要实现该接口中的方法，提供不同的解决方案。

* ConreteStrategy具体策略。
这是各个具体的算法，全都要实现抽象策略借口。

* Context封装角色。
也就是我们的算法调用者，可以根据不同的算法对象调用不同的算法。

策略模式是设计模式中较简单的一种，它的定义也很简单、清楚，仅仅利用了继承和多态机制。策略模式最大的优点就是**算法可以自由切换**，不被具体的类所固定；而且算法还可以继续扩展，如果再增加一个算法，那么不需要更改别的，直接实现算法接口就可以了，非常简单自由。

但是，策略模式也有其缺点，最大的缺陷就是，**调用者必须要知道有哪些具体策略类才能去调用**。这意味着所有的策略类都要对外暴露，这会带来很多不必要的风险。因此，该模式通常会与其他设计模式一起使用。


## [组合模式](https://blog.csdn.net/rocketeerLi/article/details/81909016)

组合模式是一种结构型设计模式。它一般是 **用来创建树状的结构，表示“部分-整体”的层次关系**。由于该模式使用的是**对象组合的方式**来实现的，区别于继承的方式，因此也叫做合成模式。先来看一下它的定义：

> Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.<br/>
> 将对象组合成树形结构以表示 “部分-整体” 的层次结构，使得用户对单个对象和组合对象的使用具有一致性。

组合模式主要包括三种角色：

* Componet抽象构件角色。定义对象的框架，可以在其中实现通用的方法、定义类的属性等等，单个对象和组合对象都要继承它。

* Leaf叶子组件。相当于树状结构中的叶子，是结构的最下层，下面没有其他组件。

* Composite树枝组件。相当于树状结构的分枝节点，下面有其他树枝组件或叶子组件，它相当于一个容器，包含下面的各个组件，是其下各个组件的父亲。

有了这三种角色就可以实现组合模式。组合模式的应用有很多，最常见的是我们的文件系统，一个文件夹下面可以有很多其他的文件夹，并且还可以有很多文件，这里的文件夹就相当于我们的树枝组件（容器），而文件就相当于叶子组件（不会包含其他组件）。

组合模式有两种不同的实现：**安全模式**和**透明模式**。从名字就可以看出来，安全模式比透明模式更安全。其实安全模式是通过 **将树枝和树叶组件分开定义** 来实现其安全性的，而透明模式是不区分的。下面来具体介绍组合模式。

注：在透明模式的实现中，树枝的方法放到了抽象构件中，因此**透明模式实现的组合模式只有两种角色。**

组合模式在创建数据库系统等复杂的对象时，是非常合适的，尤其是树形结构的对象。它的优点有两点：

* 无论树枝组件还是树叶组件，对调用者来讲是没有任何区别的，**高层模块不必关心处理的是组合对象还是单个对象**。
* 可以**自由增加对象**。就像文件系统一样，增加或删除一个文件夹或文件，仅仅只对当前的文件夹有影响，其他部分还是正常工作，这样的开发非常**符合开闭原则**，扩展十分容易。

然而组合模式也有其缺点，最大的缺点就是使用时直接使用其实现类，这与依赖倒置原则相冲突。

## [观察者模式](https://blog.csdn.net/rocketeerLi/article/details/81987089)

观察者模式是一种行为型设计模式，也叫做发布订阅模式（Publish/subcribe）。**当一个对象发生改变时，多个对象需要得到通知**，这个时候就需要利用观察者模式来实现。先看一下它的定义：

> Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. <br/>
> 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态时，则所有依赖于它的对象都会得到通知并被自动更新。

定义已经说得很明白了，甚至如何实现的都写得很清楚。这是一种**一对多的关系**，多个对象要去监视一个对象，实现的方式是利用依赖关系，这就是观察者模式。

观察者模式定义了四种角色：

* Subject 抽象被观察者。
定义被观察者的方法和属性，包括增加、删除和通知观察者的方法。

* Observer 抽象观察者。
定义观察者的通用方法，一般是收到被观察者的信息后要执行的方法。

* ConcreteSubject 具体被观察者。
实现被观察者自己的行为。

* ConcreteObserver 具体观察者。
具体实现抽象观察者中的方法。

观察者模式在项目中应用十分广泛，它最大的优点就是**增加观察者或是增加被观察者都很方便**，可以直接增加。此外，利用它进行触发机制的实现也是很方便的。当然，也有其缺点，由于通知是顺序进行通知的，当一个观察者卡顿时，其他后所有的都会停止，当然，可以利用多线程的思想来解决，这里就不是我们要讨论的了。


## [外观模式](https://blog.csdn.net/rocketeerLi/article/details/82016407)

外观模式也叫做门面模式，是一种结构型设计模式。它将一系列的类封装起来，避免其他类直接访问这些类，如果要访问这些类，必须经过这个封装的类。这个封装的类就相当于这系列类的门面一样。下面先来看一下外观模式的定义：

> Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.<br/>
> 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供一个高层次的接口，使得子系统更易于使用。

外观类封装了一系列的类，**只有通过该类才能访问这些类**，就像有一个类将所有的类都包装起来，**内部类有的方法包装类都有。**客户端调用一个方法时，并不知道哪个类去执行该方法，仅仅只是通过这个封装类进行调用。

外观模式主要有两种角色：

* Facade门面角色。
该角色持有所有内部类的对象，并且包含内部类中所有的方法，客户端通过调用该角色的方法来间接访问内部的子类。

* subsystem子系统角色。
子系统相当于多个类的集合，门面角色将其封装起来，使得客户端并不能直接调用它们的方法。子系统可以有多个。

在外观模式中，所有的类都是对门面类的依赖，客户端只需要访问门面类即可，**避免了客户端对子系统内部类的直接调用。**尤其是在子系统内部类有很多的时候，如果不使用外观模式，客户端就要持有很多内部类的对象，会造成客户端代码很臃肿。


## [备忘录模式](https://blog.csdn.net/rocketeerLi/article/details/82018168)

备忘录模式是一种行为型设计模式。它可以保存一个对象的状态，在需要的时候对其进行恢复，相当于键盘上的 `ctrl + z`。 下面先看一下它的定义：

> Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.<br/>
> 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态了。

简单地说，备忘录模式就是一种**可以让程序状态倒退**的一种方式,就像传说中的“反悔药”一样。该模式利用特定的类对需要“反悔”的类进行状态存储，在需要的时候再对其进行恢复。

备忘录模式主要包含三种角色：

* Originator发起人角色。
这是我们需要备份状态的角色，备忘录中存储的是该角色以前的状态，在需要的时候可以恢复。

* Memento备忘录角色。
该角色存储发起人角色的状态。

* Caretaker备忘录管理员角色。
该角色是发起人角色和备忘录角色之间的桥梁，负责管理备忘录。

上面介绍的仅仅是非常简单的备忘录模式，然而在具体的项目中很少能之间套用上面的模式，通常都需要进行较大的扩展和改变来适应具体的环境，例如多个状态需要回复等等。这里我们先不对其进行讨论。

## [状态模式](https://blog.csdn.net/rocketeerLi/article/details/82116249)

状态模式是一种行为型设计模式。当**对象在不同状态下有不同行为时**使用，在该模式中，我们将对象的不同状态
定义成不同的类，在这些状态类下有它们各自的行为，然后利用环境类使客户端在调用时，**不需要显示地去设置状态之间的转换**。下面先来看一下它的定义：

> Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.<br/>
> 当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。

该模式的本质是**状态的改变引起行为的改变**，从外部看就像该对象所对应的类发生了改变一样。例如，像电灯开关，在灯的不同状态下（亮或灭），按下开关时，灯的行为是不一样的。或者说汽车，只有在车停下的时候才能打开车门，行驶的时候是不可以开门的。这就是状态的不同导致行为的不同。

该模式主要有三种角色：

* State——抽象状态角色。
负责定义各个状态的行为，该抽象状态包含所有具体状态的方法。并且包含环境角色，帮助切换状态。

* ConcreteState——具体状态角色。
实现具体状态下可以执行的行为（不能执行的行为自动切换状态或不做处理）。通常来讲，**有多少行为就会产生多少状态。**

* Context——环境角色。
该角色是客户端要调用的接口，负责具体状态的切换（客户端不知道状态的切换）。

在状态模式中，所有的状态都是一个子类，如果修改状态，只需要修改这个状态的子类即可，但是增加状态不仅要增加子类，还要增加状态中的方法。状态模式最大的优点就是**外界调用不知道内部的状态改变**，只要调用其方法即可。

然而状态模式也有其缺陷之处：由于所有的状态都是一个类，有的对象可能会有非常多的状态，这个时候就使用状态模式就会导致类特别多，不利于维护。


## [访问者模式](https://blog.csdn.net/rocketeerLi/article/details/82119670)

访问者模式是一种行为型设计模式，该模式的核心是**访问者根据不同的具体类执行不同的方法**。这里的具体类一般是一个容器内的不同类，例如，一个公司下的不同职员。所有的具体类都要实现接收访问者访问的方法，然后访问者根据传进来的具体类来判断执行那个方法。先看一下访问者模式的定义：

> Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.<br/>
> 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新操作。

简而言之，就是访问者去访问不同的具体类，然后具体类将自己作为参数传给访问者，访问者再根据这些不同的具体类来实现不同的方法，这样，通过**在访问者中添加具体类的新方法**，从而达到**既给元素添加新操作，又不破坏元素结构**的效果。

定义里的某种数据结构就相当于一个大容器，各元素就是容器内部的不同类。有容器就会有遍历，由于是不同的类，因此遍历不能使用简单的迭代器，需要专门写一个类来服务。因此该模式不仅有元素类和访问者类，还要有结构对象，用来遍历或是生成容器内的元素。

访问者模式中主要包含五种角色：

* Visitor——抽象访问者。
在该抽象类（或接口）中定义访问者可以访问哪些元素。 `visit()` 方法中的不同参数决定了可以访问的具体元素。

* ConcreteVisitor——具体访问者。
实现抽象访问者中的抽象方法，根据 `visit()` 方法的不同参数来决定添加的“新操作”。

* Element——抽象元素。
定义 `accept()` 方法，用来接受访问者。其参数决定了哪一个访问者可以访问。

* ConcreteElement——具体元素。
实现抽象元素中的方法，并将自身作为参数传给访问者中的方法。

* ObjectStruture——结构对象。
就像上面所说，用来遍历或是生成容器内的元素。

访问者模式的扩展性很好，如果要继续增加新的操作，在 `Visitor` 类中添加方法或直接增加新的访问者类都可以。但如果要新增加一个具体的元素，就会相当麻烦，因此该模式不适合数据结构经常改变的项目。

访问者模式最大的缺点就是**不符合依赖倒置原则**，可以看到，访问者类依赖具体的元素类来实现添加不同的操作。这与依赖倒置原则中的依赖抽象不依赖具体相违背。


## [解释器模式](https://blog.csdn.net/rocketeerLi/article/details/82152918)

解释器模式是一种行为型设计模式，该模式主要目的是**解析一串固定模式的表达式。**解释器模式与命令模式比较相似，通常利用该模式解析语法树。下面先来看一下它的定义：

> Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.<br/>
> 给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。

简单地说，解释器就相当于翻译器一样，将一种语言转换成另一种语言。该模式使用的场景比较少，一般而言，由于已经有很多现成的“解释器”了，因此，就算使用，也是直接使用这些已经写好的来使用。

解释器模式主要有四种角色：

* AbstractExpression——抽象解释器。
定义终结符解释器和非终结解释器的行为，该抽象类（或接口）不实现具体方法。

* TerminalExpresion——终结符表达式。
实现抽象解释器的行为，解析语言中的终结符。

* NonterminalExpression——非终结符表达式。
实现抽象解释器的行为，解析语言中的非终结符。

* Context——环境角色。
构件环境类，包含解释器之外的一些全局信息，一般是 HashMap

解释器模式比较类似于命令模式，但二者处理的问题并不一样。由于笔者并没有写过解释器模式的项目，理解有限，这里就不多介绍了，如有任何错误，欢迎各位指出，谢谢。


## [享元模式](https://blog.csdn.net/rocketeerLi/article/details/82345806)

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

享元模式是根据一个特定的外部信息来存储对象的，内存中每种类型的对象只有一个。但是，在多线程程序中，由于在享元工厂中判断对象是否存在时，利用的是 `if-else` 判断语句，因此**很可能会导致线程安全问题**，使用时需要注意。当然也可以对该模式进行扩展从而避免出现线程安全问题。


## [桥接模式](https://blog.csdn.net/rocketeerLi/article/details/82351788)

桥接模式也叫桥梁模式，是一种结构型设计模式。主要目的是**实现类与类之间的解耦**。先来看一下它的定义：

> Decouple an abstraction from its implementation so that the two can vary independently.<br/>
> 将抽象和实现解耦，使得二者可以独立地变化。

桥接模式的目的还是很清楚的，就是为了解耦。而且该模式的实现也很简单，仅仅是利用了 Java 组合的性质就可以实现类的解耦功能，将抽象与实现分离开。

该模式充分利用了类与类之间的依赖关系，抽象类依赖实现类。在抽象类中调用所依赖类的方法，这样，抽象类和实现类就可以互不干扰了。

桥接模式主要包含四种角色：

* Abstraction——抽象化角色。
抽象类或接口，定义具体角色的行为，在抽象角色中显示声明需要依赖实现类。

* Implementor——实现化角色。
抽象类或接口，定义实现角色的行为。

* RefinedAbstraction——修正抽象化角色。
实现抽象角色的行为，在该行为中调用所依赖的实现类中的方法。

* ConcreteImplementor——具体实现化角色。
实现实现化角色，具体实现抽象类所需的行为，但实现过程与抽象类无关。 

很多设计模式都用到了组合的方式来实现，像策略模式，桥接模式等等，但是实现的目的有所不同。不得不说，组合的应用场景还是很多的，相比于继承，在设计模式中，更推荐的就是组合方式，**能用组合的地方就尽量不要使用继承**。


## [迭代器模式](https://blog.csdn.net/rocketeerLi/article/details/82353311)

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

简单地说，**迭代器就像一个容器的游标一样，可以遍历容器内部的所有元素**。

如果没有语言内置的迭代器，迭代器模式还是挺困难的一个设计模式，但是，由于大部分语言已经含有了这个模式，因此，该模式基本不会单独出现，我们应该尽量使用语言内置的迭代器，避免自己重新搭建。

# 最后

以上是我在学习设计模式时候的总结，可能会有一些错误，希望看到的话能够指出，谢谢。
