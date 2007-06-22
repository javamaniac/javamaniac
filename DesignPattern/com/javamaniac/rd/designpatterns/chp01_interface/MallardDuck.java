package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.Flying;
import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.NoneFlying;
import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.Quacking;

public class MallardDuck extends Duck {

	public MallardDuck()
	{
		flyingBehaviors = new Flying();
		quackingBehaviors = new Quacking();
//		performFly(new Flying());
//		performQuack(new Quacking());
	}
	
	public void display() {
		System.out.println("Un canard mallard");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		
		duck.display();
		duck.swim();
		duck.fly();
		duck.quack();
		
		
		duck.flyingBehaviors = new NoneFlying();
		duck.display();
		duck.swim();
		duck.fly();
		duck.quack();
	}

}
