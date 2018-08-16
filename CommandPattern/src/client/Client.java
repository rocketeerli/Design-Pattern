package client;

import command.Command;
import command.SitCommand;
import command.WalkCommand;
import invokers.Invoker;
import receivers.Cat;
import receivers.Dog;
import receivers.Receiver;

public class Client {

	public static void main(String[] args) {
		//��������ߡ�
		Invoker invoker = new Invoker();
		//����ִ���ߣ�è�͹�����
		Receiver cat = new Cat();
		Receiver dog = new Dog();
		//���
		System.out.println("��ʼ��------------");
		Command walkCommand = new WalkCommand();
		walkCommand.setReceiver(cat, dog);
		invoker.setCommand(walkCommand);
		invoker.action();
		
		System.out.println("������------------");
		Command sitCommand = new SitCommand();
		sitCommand.setReceiver(cat, dog);
		invoker.setCommand(sitCommand);
		invoker.action();
	}

}
