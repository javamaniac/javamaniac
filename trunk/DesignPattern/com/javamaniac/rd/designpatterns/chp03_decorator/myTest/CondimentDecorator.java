package com.javamaniac.rd.designpatterns.chp03_decorator.myTest;

public abstract class CondimentDecorator extends Brevage {
	
	// Le livre propose de tout mettre l'implémentation dans les classes concretes (ex : Mocha) plutôt qu'ici
	//public abstract String getDescription();
	
	protected Brevage brevage;
	
	@Override
	public String getDescription() {
		return brevage.getDescription() + " with " + description;
	}

}
