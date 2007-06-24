package com.javamaniac.rd.designpatterns.chp02_observer.simpleObserver;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();

	public void notifyObservers() {
		System.out.println("--- notify broadcast ---");
		for (Observer observer : observers) {
			observer.update();
		}

	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

}
