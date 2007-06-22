package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.NoneFlying;

public class WoodenDuck extends Duck {

	public WoodenDuck()
	{
		flyingBehaviors = new NoneFlying();
		quackingBehaviors = new NoneQuacking();
//		performFly(new NoneFlying());
//		performQuack(new NoneQuacking());
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
		duck.fly();
		duck.quack();		
	}

}
