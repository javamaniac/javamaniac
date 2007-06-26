package com.javamaniac.rd.designpatterns.chp03_decorator.breuvages;

import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.brevages.HouseBlend;
import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.condiments.Mocha;
import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.condiments.Whip;

public class Main {

	public Main() {
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
		
	}

}
