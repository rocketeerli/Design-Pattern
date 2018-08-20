package component;

import java.util.ArrayList;

public class Father extends Person {
	private ArrayList<Person> personList = new ArrayList<>();
	public Father(String name) {
		super(name);
	}
	//����һ���˵Ĺ�ϵ��
	public void add(Person person) {
		this.personList.add(person);
	}
	//ɾ��һ���˵Ĺ�ϵ��
	public void remove(Person person) {
		this.personList.remove(person);
	}
	//������µ������ˣ��������׺Ͷ��ӣ���
	public ArrayList<Person> getChildren() {
		return this.personList;
	}
}
