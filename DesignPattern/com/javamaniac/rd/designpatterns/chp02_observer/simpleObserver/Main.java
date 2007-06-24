package com.javamaniac.rd.designpatterns.chp02_observer.simpleObserver;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Subject subject = new SubjectImpl();
		
		Observer observer1 = new ObserverImpl("observer 1");
		Observer observer2 = new ObserverImpl("observer 2");
		
		subject.registerObserver(observer1);
		subject.registerObserver(observer2);
		
		subject.notifyObservers();

		Observer observer3 = new ObserverImpl("observer 3");
		
		subject.registerObserver(observer3);
		subject.removeObserver(observer2);

		subject.notifyObservers();

	}

}
