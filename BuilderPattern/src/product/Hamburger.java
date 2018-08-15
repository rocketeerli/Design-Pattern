package product;

import java.util.ArrayList;
import java.util.List;

public abstract class Hamburger {
	private List<Food> part = new ArrayList<>();
	
	public void addFood(Food food) {
		part.add(food);
	}
	
	public void showFood() {
		System.out.println("������ɣ�");
		for (Food food : part) {
			System.out.print(food.getName() + "\t");
		}
		System.out.println("");
	}
}
