package resterant;

public class PersonMing extends Person {
	@Override
	protected void eatSonething() {
		System.out.println("һ�ݸǷ�!!! ");
	}
	@Override
	protected void drinkSomthing() {
		System.out.println("һƿѩ��!!! ");
	}
	public void setNeedPaper(boolean needPaper) {
		this.needPaper = needPaper;
	}
}
