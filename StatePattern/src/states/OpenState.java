package states;

public class OpenState extends State {
	@Override
	public void open() {
		//�����ٴδ��š�
		System.out.println("���Ѿ��ǿ��ŵ��ˡ�");
	}
	@Override
	public void close() {
		System.out.println("�Ź�����");		
	}
}
