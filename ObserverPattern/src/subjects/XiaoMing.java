package subjects;

public class XiaoMing extends Subject {
	public void eat() {
		System.out.println("����С�������ڳԷ�");
		super.notifyObservers("С���ڳԷ�");
	}
	public void doHomework() {
		System.out.println("����С��,����д��ҵ");
		super.notifyObservers("С����д��ҵ");
	}
}
