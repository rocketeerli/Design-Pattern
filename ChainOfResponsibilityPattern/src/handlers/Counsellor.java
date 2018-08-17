package handlers;

import requests.Request;

public class Counsellor extends Handler {
	public Counsellor(int level) {
		super(level);
	}
	@Override
	protected void response(Request request) {
		System.out.println("学生的请求是：");
		System.out.println(request.getRequest());
		System.out.println("导员同意了该学生的请求...");
	}
}
