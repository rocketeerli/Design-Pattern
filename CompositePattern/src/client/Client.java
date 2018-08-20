package client;

import component.Father;
import component.Person;
import component.Son;

public class Client {

	public static void main(String[] args) {
		//���ȡ�
		Father root = new Father("����");
		root.getName();
		Father branch = new Father("����");
		Son leaf = new Son("����");
		root.add(branch);
		branch.add(leaf);
	}
	public static void display(Father root) {
		for (Person person : root.getChildren()) {
			if (person instanceof Son) {
				person.getName();
			} else {
				display((Father)person);
			}
		}
	}
}
