# 介绍

-------------------

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

# 安全模式

----------------------

拿我们的文件系统举例，这里需要二者的抽象构件：

	public abstract class FileSystem {
		protected String fileName = "";
		public FileSystem(String fileName) {
			this.fileName = fileName;
		}
	}

然后定义我们的树枝和树叶组件，也就是我们的文件夹和文件：

文件夹：

	public class Folder extends FileSystem {
		private List<FileSystem> fileList = new ArrayList<>();
		public Folder(String fileName) {
			super(fileName);
		}
		//新建文件夹或文件。
		public void add(FileSystem fileSystem) {
			this.fileList.add(fileSystem);
		}
		//删除文件夹或文件。
		public void remove(FileSystem fileSystem) {
			this.fileList.remove(fileSystem);
		}
		//获得下面的所有文件、文件夹信息。
		public List<FileSystem> getChildren() {
			return this.fileList;
		}
		@Override
		public String toString() {
			String name = "文件夹名：" + this.fileName + "\n";
			for (FileSystem fileSystem : fileList) {
				name = name + fileSystem;
			}
			return name;
		}
	}

文件：

	public class File extends FileSystem {
		public File(String fileName) {
			super(fileName);
		}
		@Override
		public String toString() {
			return "文件名：" + this.fileName + "\n";
		}
	}

最后，三种组件都定义好后，就可以开始我们的测试了：

	public static void main(String[] args) {
		Folder root = new Folder("我的电脑");
		Folder branch = new Folder("我的图片");
		File leaf = new File("图片.jpg");
		root.add(branch);
		branch.add(leaf);
		display(root);
	}
	public static void display(Folder root) {
		for (FileSystem fileSystem : root.getChildren()) {
			System.out.println(fileSystem);
		}
	}

输出结果：

> 文件夹名：我的图片<br/>
文件名：图片.jpg

这就是安全模式实现的组合模式，它通过将树枝和树叶分开定义来保证系统的安全性。

# 透明模式

----------------------

透明模式是将安全模式中具体类中的方法放到了抽象类中，例如 `add()` 方法、 `remove()`方法和 `getChildren()` 方法等。来看我们更改后的代码：

抽象构件：

	public abstract class FileSystem {
		protected List<FileSystem> fileList = new ArrayList<>();
		protected String fileName = "";
		public FileSystem(String fileName) {
			this.fileName = fileName;
		}
		//新建文件夹或文件。
		public void add(FileSystem fileSystem) {
			this.fileList.add(fileSystem);
		}
		//删除文件夹或文件。
		public void remove(FileSystem fileSystem) {
			this.fileList.remove(fileSystem);
		}
		//获得下面的所有文件、文件夹信息。
		public List<FileSystem> getChildren() {
			return this.fileList;
		}
		@Override
		public String toString() {
			String name = "文件夹名：" + this.fileName + "\n";
			for (FileSystem fileSystem : fileList) {
				name = name + fileSystem;
			}
			return name;
		}
	}

文件夹和文件是相同的：

	public class File extends FileSystem {
		public File(String fileName) {
			super(fileName);
		}
		//透明模式。
		@Override
		public String toString() {
			String name = "文件夹名：" + this.fileName + "\n";
			for (FileSystem fileSystem : this.fileList) {
				name = name + fileSystem;
			}
			return name;
		}
	}


最后的测试代码，与安全模式稍有不同：

	public static void main(String[] args) {
		File root = new File("我的电脑");
		File branch = new File("我的图片");
		File leaf = new File("图片.jpg");
		root.add(branch);
		branch.add(leaf);
		display(root);
	}
	public static void display(FileSystem root) {
		for (FileSystem fileSystem : root.getChildren()) {
			System.out.println(fileSystem);
		}
	}

输出结果：

> 文件夹名：我的图片<br/>
文件夹名：图片.jpg

可以看到，该模式中的树枝组件和树叶组件结构是一样的，这样就比安全模式少了一个实现类。但这样就会出现一个问题，由于叶子组件是不能使用这些方法的，但是方法放在抽象类中的话，它就可以使用了。这就会造成潜在的危险。虽然叶子组件可以在这些方法可以重写，但并没有什么必要，因此这里还是建议使用安全模式来实现组合模式。


# 总结

----------------------

组合模式在创建数据库系统等复杂的对象时，是非常合适的，尤其是树形结构的对象。它的优点有两点：

* 无论树枝组件还是树叶组件，对调用者来讲是没有任何区别的，**高层模块不必关心处理的是组合对象还是单个对象**。
* 可以**自由增加对象**。就像文件系统一样，增加或删除一个文件夹或文件，仅仅只对当前的文件夹有影响，其他部分还是正常工作，这样的开发非常**符合开闭原则**，扩展十分容易。

然而组合模式也有其缺点，最大的缺点就是使用时直接使用其实现类，这与依赖倒置原则相冲突。
