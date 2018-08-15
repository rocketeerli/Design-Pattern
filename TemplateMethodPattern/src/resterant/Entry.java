package resterant;

public class Entry {
	public static void main(String[] args) {
		
		PersonHong xiaoHong = new PersonHong();
		PersonMing xiaoMing = new PersonMing();
		System.out.println("小红点餐-----------");
		xiaoHong.eat();
		System.out.println("小明点餐-----------");
		xiaoMing.setNeedPaper(false);
		xiaoMing.eat();
		
	}
}
