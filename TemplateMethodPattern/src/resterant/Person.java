package resterant;

public abstract class Person {
	protected boolean needPaper = true;
	//��ʳ��
	protected abstract void eatSonething();
	//���ϡ�
	protected abstract void drinkSomthing();
	//�ͽ�ֽ��
	private void paper() {
		System.out.println("��Ҫ�ͽ�ֽ!!! ");
	}
	//���͡�
	public final void eat() {
		this.eatSonething();
		this.drinkSomthing();
		if (needPaper) {
			paper();
		}
	}
}
