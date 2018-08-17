package handlers;

import requests.Request;

public abstract class Handler {
	private int level;
	private Handler nextHandler = null;
	public Handler(int level) {
		this.level = level;
	}
	public void HandleMessage(Request request) {
		if (this.level == request.getLevel()) {
			this.response(request);
		} else if (this.nextHandler != null) {      //������һ�������ߡ�
			this.nextHandler.HandleMessage(request);
		} else {
			System.out.println("�޷������ѧ��������...");
		}
	}
	public void setNext(Handler handler) {
		this.nextHandler = handler;
	}
	protected abstract void response(Request request);
}
