package DIP;

public class Person {
	
	void eat(Fruit fruit) {
		fruit.eaten();
	}
	
	

	public static void main(String[] args) {
		Person xiaoMing = new Person();
		Fruit apple = new Apple();
		xiaoMing.eat(apple);
	}

}
