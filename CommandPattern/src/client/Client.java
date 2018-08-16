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
		//命令调用者。
		Invoker invoker = new Invoker();
		//命令执行者（猫和狗）。
		Receiver cat = new Cat();
		Receiver dog = new Dog();
		//命令。
		System.out.println("开始走------------");
		Command walkCommand = new WalkCommand();
		walkCommand.setReceiver(cat, dog);
		invoker.setCommand(walkCommand);
		invoker.action();
		
		System.out.println("都坐下------------");
		Command sitCommand = new SitCommand();
		sitCommand.setReceiver(cat, dog);
		invoker.setCommand(sitCommand);
		invoker.action();
	}

}
