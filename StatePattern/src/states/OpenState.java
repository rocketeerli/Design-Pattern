package states;

public class OpenState extends State {
	@Override
	public void open() {
		//不能再次打开门。
		System.out.println("门已经是开着的了。");
	}
	@Override
	public void close() {
		System.out.println("门关上了");		
	}
}
