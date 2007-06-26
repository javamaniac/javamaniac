package com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.condiments;

import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.Brevage;
import com.javamaniac.rd.designpatterns.chp03_decorator.breuvages.CondimentDecorator;

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
