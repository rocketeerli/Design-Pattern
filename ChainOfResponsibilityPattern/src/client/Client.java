package client;

import handlers.Counsellor;
import handlers.Dean;
import handlers.Handler;
import handlers.President;
import requests.Student;

public class Client {

	public static void main(String[] args) {
		Handler president = new President(1);
		Handler dean = new Dean(2);
		Handler counsellor = new Counsellor(3);
		counsellor.setNext(dean);
		dean.setNext(president);
		counsellor.HandleMessage(new Student(3, "我要换寝室..."));
		System.out.println(":------------------------");
		counsellor.HandleMessage(new Student(1, "我要转学..."));
	}

}
