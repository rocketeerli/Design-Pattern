package driver;

public class CarOwner extends Driver {
	private Driver proxyDriver = null;
	@Override
	public void driveCar() {
		if (proxyDriver == null ) {
			System.out.println("�޴��ݻ���ݲ���ָ���ģ����ܿ���...");
		} else {
			System.out.println("�����ؼ�...");
		}	
	}
	@Override
	public Driver getProxy() {
		this.proxyDriver = new ProxyDriver(this);
		return this.proxyDriver;
	}
}
