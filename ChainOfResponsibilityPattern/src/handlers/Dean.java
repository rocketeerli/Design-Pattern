package handlers;

import requests.Request;

public class Dean extends Handler {
	public Dean(int level) {
		super(level);
	}
	@Override
	protected void response(Request request) {
		System.out.println("ѧ���������ǣ�");
		System.out.println(request.getRequest());
		System.out.println("Ժ��ͬ���˸�ѧ��������...");
	}
}
