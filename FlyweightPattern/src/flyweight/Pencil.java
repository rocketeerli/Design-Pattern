package flyweight;

public class Pencil extends Pen {
	public Pencil(String penType) {
		super(penType);
		System.out.println("������һ��" + penType + "�ͺŵ�Ǧ��");
	}
	@Override
	public void introduce() {
		System.out.println("����Ǧ�ʣ��ҵ������ǣ�" + this.penType);
	}
}
