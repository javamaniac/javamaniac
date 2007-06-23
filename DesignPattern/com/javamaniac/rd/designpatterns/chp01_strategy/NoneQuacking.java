package com.javamaniac.rd.designpatterns.chp01_strategy;

import com.javamaniac.rd.designpatterns.chp01_strategy.duckBehaviors.QuackingBehaviors;

public class NoneQuacking implements QuackingBehaviors {

	public void quack() {
		System.out.println("...");

	}

}
