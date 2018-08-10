package decoratorPattern;

public class Test {
	public static void main(String[] args) {
		Father father = new Father(new Teacher(new Student(new GoodPerson())));
		father.talk();
	}
}
