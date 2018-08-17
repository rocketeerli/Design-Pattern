package requests;

public abstract class Request {
	private int level;
	private String request;
	public Request(int level, String request) {
		this.level = level;
		this.request = request;
	}
	public int getLevel() {
		return this.level;
	}
	public String getRequest() {
		return this.request;
	}
}
