package driver;

public class ProxyDriver extends Driver {
	private Driver drunkDriver;
	public ProxyDriver(Driver drunkDriver) {
		this.drunkDriver = drunkDriver;
	}
	@Override
	public void driveCar() {
		this.drunkDriver.driveCar();
	}
	//代理类的代理，暂时设为它自己。
	@Override
	public Driver getProxy() {
		return this;
	}
}
