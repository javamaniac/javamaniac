package dominicm.alasoupe.recettes.ingredients;

import dominicm.alasoupe.aliments.Aliment;

public class IngredientImpl implements Ingredient {

	private Quantite quantite;
	private UniteMesure uniteMesure;
	private Aliment aliment;

	public IngredientImpl(Quantite quantite, UniteMesure uniteMesure, Aliment aliment)
	{
		this.quantite = quantite;
		this.uniteMesure = uniteMesure;
		this.aliment = aliment;
	}

	public String toString()
	{
		return quantite + " " + uniteMesure + " " + aliment;
	}
}
