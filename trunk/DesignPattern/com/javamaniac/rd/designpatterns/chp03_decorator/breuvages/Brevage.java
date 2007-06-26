package com.javamaniac.rd.designpatterns.chp03_decorator.breuvages;

public abstract class Brevage {

	public String description;
	
	public String getDescription()
	{
		return description;
	}
	
	public abstract double cost();
	
}
