package com.javamaniac.rd.designpatterns.chp03_decorator.myTest;

import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.brevages.HouseBlend;
import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.condiments.Mocha;
import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.condiments.Whip;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Bien...
		Brevage houseBlend = new HouseBlend();
		Brevage houseBlendWithMocha = new Mocha(houseBlend);
		Brevage houseBlendWithMochaAndWhip = new Whip(houseBlendWithMocha);
		System.out.println("Price of a "
				+ houseBlendWithMochaAndWhip.getDescription() + " is "
				+ houseBlendWithMochaAndWhip.cost());
		

		//...mais encore plus simple
		Brevage breuvage = new HouseBlend();
		breuvage = new Mocha(breuvage);
		breuvage = new Whip(breuvage);
		System.out.println("Price of a "
				+ houseBlendWithMochaAndWhip.getDescription() + " is "
				+ houseBlendWithMochaAndWhip.cost());
		
	}

}
