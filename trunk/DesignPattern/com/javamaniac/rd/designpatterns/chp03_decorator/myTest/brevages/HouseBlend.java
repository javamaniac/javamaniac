package com.javamaniac.rd.designpatterns.chp03_decorator.myTest.brevages;

import com.javamaniac.rd.designpatterns.chp03_decorator.myTest.Brevage;

public class HouseBlend extends Brevage {

	public HouseBlend() {
		description = "HouseBlend";
	}
	
	@Override
	public double cost() {
		return 0.89d;
	}

}
