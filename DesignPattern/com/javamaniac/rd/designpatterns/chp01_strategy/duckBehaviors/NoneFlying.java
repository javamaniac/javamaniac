package com.javamaniac.rd.designpatterns.chp01_strategy.duckBehaviors;

public class NoneFlying implements FlyingBehaviors {

	public void fly() {
		System.out.println("Le canard ne s'envole pas!");

	}

}
