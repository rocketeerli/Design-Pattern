package resterant;

public class PersonMing extends Person {
	@Override
	protected void eatSonething() {
		System.out.println("Ò»·Ý¸Ç·¹!!! ");
	}
	@Override
	protected void drinkSomthing() {
		System.out.println("Ò»Æ¿Ñ©±Ì!!! ");
	}
	public void setNeedPaper(boolean needPaper) {
		this.needPaper = needPaper;
	}
}
