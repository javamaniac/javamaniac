package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.QuackingBehaviors;

public class NoneQuacking implements QuackingBehaviors {

	public void quack() {
		System.out.println("...");

	}

}
