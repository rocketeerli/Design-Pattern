package subjects;

public class XiaoMing extends Subject {
	public void eat() {
		System.out.println("我是小明，我在吃饭");
		super.notifyObservers("小明在吃饭");
	}
	public void doHomework() {
		System.out.println("我是小明,我在写作业");
		super.notifyObservers("小明在写作业");
	}
}
