package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.NoneFlying;

public class WoodenDuck extends Duck {

	public WoodenDuck()
	{
		setFlyingBehaviors(new NoneFlying());
		setQuackingBehaviors(new NoneQuacking());
	}
	
	public void display() {
		System.out.println("Un canard de bois");
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Duck duck = new WoodenDuck();
		
		duck.display();
		duck.swim();
		duck.performFly();
		duck.performQuack();		
	}

}
