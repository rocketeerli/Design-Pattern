package resterant;

public class PersonHong extends Person {
	@Override
	protected void eatSonething() {
		System.out.println("һ������!!! ");
	}
	@Override
	protected void drinkSomthing() {
		System.out.println("һ����֭!!! ");	
	}
	public void setNeedPaper(boolean needPaper) {
		this.needPaper = needPaper;
	}
}
