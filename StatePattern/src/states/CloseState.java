package states;

public class CloseState extends State {
	@Override
	public void open() {
		System.out.println("�Ŵ���");
	}
	@Override
	public void close() {
		//�����ظ����š�
		System.out.println("���Ѿ��ǹ��ϵ��ˡ�");
	}
}
