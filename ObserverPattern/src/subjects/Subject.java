package subjects;

import java.util.ArrayList;
import java.util.List;

import observers.Observer;

public abstract class Subject {
	private List<Observer> observerList = new ArrayList<>();
	//增加观察者。
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}
	//删除观察者。
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);
	}
	//通知所有的观察者。
	public void notifyObservers(String context) {
		for (Observer observer : observerList) {
			observer.see(context);
		}
	}
}
