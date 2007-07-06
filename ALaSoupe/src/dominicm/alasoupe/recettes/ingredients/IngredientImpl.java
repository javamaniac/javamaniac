package dominicm.alasoupe.recettes.ingredients;

import dominicm.alasoupe.aliments.Aliment;

public class IngredientImpl implements Ingredient {

	private int quantite;
	private UniteMesure uniteMesure;
	private Aliment aliment;

	public IngredientImpl(int quantite, UniteMesure uniteMesure, Aliment aliment)
	{
		this.quantite = quantite;
		this.uniteMesure = uniteMesure;
		this.aliment = aliment;
	}

}
