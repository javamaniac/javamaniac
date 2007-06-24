package com.javamaniac.rd.designpatterns.chp02_observer.javaObserver;

import java.util.Observable;
import java.util.Observer;
import com.javamaniac.rd.designpatterns.chp02_observer.javaObserver.ObserverImpl;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Observable subject = new Observable();
		
		Observer observer1 = new ObserverImpl("observer 1");
		Observer observer2 = new ObserverImpl("observer 2");
		
		subject.addObserver(observer1);
		subject.addObserver(observer2);
		
		System.out.println("--- notify ---");
		//subject.notifyObservers();
		//subject.setChanged();

		Observer observer3 = new ObserverImpl("observer 3");
		
		subject.addObserver(observer3);
		subject.deleteObserver(observer2);

		System.out.println("--- notify ---");
		subject.notifyObservers();		
	}

}
