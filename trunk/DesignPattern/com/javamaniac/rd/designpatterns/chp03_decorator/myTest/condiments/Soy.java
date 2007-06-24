package com.javamaniac.rd.designpatterns.chp03_decorator.myTest.condiments;

import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.Brevage;
import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.CondimentDecorator;

public class Soy extends CondimentDecorator  {

	public Soy(Brevage b) {
		brevage = b;
		description = "Soy";
	}
	
	@Override
	public double cost() {
		return 0.15d + brevage.cost();
	}

}
