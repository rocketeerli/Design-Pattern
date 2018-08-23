package subjects;

import java.util.ArrayList;
import java.util.List;

import observers.Observer;

public abstract class Subject {
	private List<Observer> observerList = new ArrayList<>();
	//���ӹ۲��ߡ�
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}
	//ɾ���۲��ߡ�
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);
	}
	//֪ͨ���еĹ۲��ߡ�
	public void notifyObservers(String context) {
		for (Observer observer : observerList) {
			observer.see(context);
		}
	}
}
