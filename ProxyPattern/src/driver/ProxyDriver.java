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
	//������Ĵ�����ʱ��Ϊ���Լ���
	@Override
	public Driver getProxy() {
		return this;
	}
}
