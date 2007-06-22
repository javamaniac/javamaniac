package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.FlyingBehaviors;
import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.QuackingBehaviors;

public abstract class Duck {

	protected FlyingBehaviors flyingBehaviors;
	protected QuackingBehaviors quackingBehaviors;
	
	public abstract void display();
	
	public void swim()
	{
		System.out.println("Swim...");
	}
	
	public void fly()
	{
		flyingBehaviors.fly();
	}
	
	public void quack()
	{
		quackingBehaviors.quack();
	}
	
//	protected void performFly(FlyingBehaviors f)
//	{
//		flyingBehaviors = f;
//	}
//	
//	protected void performQuack(QuackingBehaviors q)
//	{
//		quackingBehaviors = q;
//	}
	
	
	
}
