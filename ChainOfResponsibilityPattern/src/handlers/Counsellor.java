package handlers;

import requests.Request;

public class Counsellor extends Handler {
	public Counsellor(int level) {
		super(level);
	}
	@Override
	protected void response(Request request) {
		System.out.println("ѧ���������ǣ�");
		System.out.println(request.getRequest());
		System.out.println("��Աͬ���˸�ѧ��������...");
	}
}
