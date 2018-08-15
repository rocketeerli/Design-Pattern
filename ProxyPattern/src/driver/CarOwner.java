package driver;

public class CarOwner extends Driver {
	private Driver proxyDriver = null;
	@Override
	public void driveCar() {
		if (proxyDriver == null ) {
			System.out.println("无代驾或代驾不是指定的，不能开车...");
		} else {
			System.out.println("开车回家...");
		}	
	}
	@Override
	public Driver getProxy() {
		this.proxyDriver = new ProxyDriver(this);
		return this.proxyDriver;
	}
}
