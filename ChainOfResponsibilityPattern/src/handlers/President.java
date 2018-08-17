package handlers;

import requests.Request;

public class President extends Handler {
	public President(int level) {
		super(level);
	}
	@Override
	protected void response(Request request) {
		System.out.println("学生的请求是：");
		System.out.println(request.getRequest());
		System.out.println("校长同意了该学生的请求...");
	}
}
