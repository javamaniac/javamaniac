package com.javamaniac.rd.designpatterns.chp02_observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

public class ObserverImpl implements Observer {

	private String observerName;

	public ObserverImpl(String name) {
		observerName = name;
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(observerName + " a été mis à jour");
		
	}


}
