package resterant;

public class Entry {
	public static void main(String[] args) {
		
		PersonHong xiaoHong = new PersonHong();
		PersonMing xiaoMing = new PersonMing();
		System.out.println("С����-----------");
		xiaoHong.eat();
		System.out.println("С�����-----------");
		xiaoMing.setNeedPaper(false);
		xiaoMing.eat();
		
	}
}
