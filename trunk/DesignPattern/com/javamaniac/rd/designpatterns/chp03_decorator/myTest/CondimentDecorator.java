package com.javamaniac.rd.designpatterns.chp03_decorator.myTest;

public abstract class CondimentDecorator extends Brevage {
	
	// Le livre propose de tout mettre l'impl�mentation dans les classes concretes (ex : Mocha) plut�t qu'ici
	//public abstract String getDescription();
	
	protected Brevage brevage;
	
	@Override
	public String getDescription() {
		return brevage.getDescription() + " with " + description;
	}

}
