package handlers;

import requests.Request;

public class President extends Handler {
	public President(int level) {
		super(level);
	}
	@Override
	protected void response(Request request) {
		System.out.println("ѧ���������ǣ�");
		System.out.println(request.getRequest());
		System.out.println("У��ͬ���˸�ѧ��������...");
	}
}
