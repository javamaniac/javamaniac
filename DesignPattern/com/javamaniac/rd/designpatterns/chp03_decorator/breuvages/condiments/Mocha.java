package com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.condiments;

import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.Brevage;
import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	public Mocha(Brevage b) {
		brevage = b;
		description = "Mocha";
	}
	
	@Override
	public double cost() {
		return 0.20d + brevage.cost();
	}
}
