package adaptors;

import birds.Bird;
import birds.WildGoose;

//¶ÔÏóÊÊÅäÆ÷¡£
public class Adapter implements Bird {
	WildGoose wildGoose = new WildGoose();
	@Override
	public void fly() {
		wildGoose.wildGooseFly();
	}
}

//ÀàÊÊÅäÆ÷¡£
//public class Adapter extends WildGoose implements Bird {
//	@Override
//	public void fly() {
//		super.wildGooseFly();
//	}
//}
