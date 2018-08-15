package resterant;

public class PersonHong extends Person {
	@Override
	protected void eatSonething() {
		System.out.println("一碗面条!!! ");
	}
	@Override
	protected void drinkSomthing() {
		System.out.println("一杯果汁!!! ");	
	}
	public void setNeedPaper(boolean needPaper) {
		this.needPaper = needPaper;
	}
}
