package com.javamaniac.rd.designpatterns.chp02_observer.simpleObserver;

public interface Subject {

	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
