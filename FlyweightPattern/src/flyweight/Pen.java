package flyweight;

public abstract class Pen {
	//内部状态
	private int length;
	//外部状态
	protected final String penType;
	//享元角色必须接受外部状态，且不能更改。
	public Pen(String penType) {
		this.penType = penType;
	}
	//根据外部状态做出的操作。
	public abstract void introduce();
	//内部状态的操作。
	public int getLength() {
		return this.length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
