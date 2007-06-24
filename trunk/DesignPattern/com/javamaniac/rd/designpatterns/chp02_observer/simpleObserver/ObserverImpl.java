package com.javamaniac.rd.designpatterns.chp02_observer.simpleObserver;

public class ObserverImpl implements Observer {

	
	private String observerName;

	public ObserverImpl(String name) {
		observerName = name;
	}
	
	public void update() {
		System.out.println(observerName + " a été mis à jour");
		
	}

}
