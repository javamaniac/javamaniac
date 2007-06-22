package com.javamaniac.rd.designpatterns.chp01_interface;

import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.FlyingBehaviors;
import com.javamaniac.rd.designpatterns.chp01_interface.duckBehaviors.QuackingBehaviors;

public abstract class Duck {

	private FlyingBehaviors flyingBehaviors;
	private QuackingBehaviors quackingBehaviors;
	
	public abstract void display();
	
	public void swim()
	{
		System.out.println("Swim...");
	}
	
	public void performFly()
	{
		flyingBehaviors.fly();
	}
	
	public void performQuack()
	{
		quackingBehaviors.quack();
	}
	
	protected void setFlyingBehaviors(FlyingBehaviors f)
	{
		flyingBehaviors = f;
	}
	
	protected void setQuackingBehaviors(QuackingBehaviors q)
	{
		quackingBehaviors = q;
	}
	
	
	
}
