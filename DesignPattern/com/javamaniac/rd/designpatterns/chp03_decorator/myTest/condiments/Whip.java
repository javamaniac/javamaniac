package com.javamaniac.rd.designpatterns.chp03_decorator.myTest.condiments;

import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.Brevage;
import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.CondimentDecorator;

public class Whip extends CondimentDecorator {

	public Whip(Brevage b) {
		brevage = b;
		description = "Whip";
	}
	
	@Override
	public double cost() {
		return 0.120d + brevage.cost();
	}

}
