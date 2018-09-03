package flyweight;

public class Pencil extends Pen {
	public Pencil(String penType) {
		super(penType);
		System.out.println("生产了一根" + penType + "型号的铅笔");
	}
	@Override
	public void introduce() {
		System.out.println("我是铅笔，我的类型是：" + this.penType);
	}
}
