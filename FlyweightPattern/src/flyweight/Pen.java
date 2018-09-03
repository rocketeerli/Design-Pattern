package flyweight;

public abstract class Pen {
	//�ڲ�״̬
	private int length;
	//�ⲿ״̬
	protected final String penType;
	//��Ԫ��ɫ��������ⲿ״̬���Ҳ��ܸ��ġ�
	public Pen(String penType) {
		this.penType = penType;
	}
	//�����ⲿ״̬�����Ĳ�����
	public abstract void introduce();
	//�ڲ�״̬�Ĳ�����
	public int getLength() {
		return this.length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
