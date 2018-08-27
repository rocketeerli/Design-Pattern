package states;

public class CloseState extends State {
	@Override
	public void open() {
		System.out.println("门打开了");
	}
	@Override
	public void close() {
		//不能重复关门。
		System.out.println("门已经是关上的了。");
	}
}
