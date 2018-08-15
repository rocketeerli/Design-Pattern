package resterant;

public abstract class Person {
	protected boolean needPaper = true;
	//主食。
	protected abstract void eatSonething();
	//饮料。
	protected abstract void drinkSomthing();
	//餐巾纸。
	private void paper() {
		System.out.println("需要餐巾纸!!! ");
	}
	//开餐。
	public final void eat() {
		this.eatSonething();
		this.drinkSomthing();
		if (needPaper) {
			paper();
		}
	}
}
