package abstraction;

import implementor.Lunch;

public class XiaoMing extends Person {
	public XiaoMing(Lunch lunch) {
		super(lunch);
	}
	@Override
	public void eatLunch() {
		System.out.println("Ð¡Ã÷ÔÚ³ÔÎç·¹¡£");
		super.eatLunch();
	}
}
