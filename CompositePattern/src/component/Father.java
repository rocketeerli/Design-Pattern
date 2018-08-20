package component;

import java.util.ArrayList;

public class Father extends Person {
	private ArrayList<Person> personList = new ArrayList<>();
	public Father(String name) {
		super(name);
	}
	//增加一个人的关系。
	public void add(Person person) {
		this.personList.add(person);
	}
	//删除一个人的关系。
	public void remove(Person person) {
		this.personList.remove(person);
	}
	//这个人下的所有人（包括父亲和儿子）。
	public ArrayList<Person> getChildren() {
		return this.personList;
	}
}
