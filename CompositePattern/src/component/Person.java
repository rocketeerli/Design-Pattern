package component;

public abstract class Person {
	private String name = "";
	public Person(String name) {
		this.name = name;
	}
	public void getName() {
//		return "������" + name;
		System.out.println("������" + name);
	}
}
