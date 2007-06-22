package com.javamaniac.rd.designpatterns.chp01_interface;

import java.util.ArrayList;
import java.util.List;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.NoneFlying;

public class MiniDuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Duck> etang = new ArrayList<Duck>();
		etang.add(new MallardDuck());
		etang.add(new WoodenDuck());
		Duck canardMalade = new MallardDuck();
		canardMalade.setFlyingBehaviors(new NoneFlying());
		etang.add(canardMalade);
		

		for (Duck duck : etang) {
			System.out.println("----");
			duck.display();
			duck.swim();
			duck.performFly();
			duck.performQuack();			
		}
	}

}
