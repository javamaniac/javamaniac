package dominicm.alasoupe.recettes;

import java.util.List;

import dominicm.alasoupe.recettes.ingredients.IngredientImpl;

public class RecetteImpl implements Recette {

	private List<Classifiable> classifiable;
	private List<IngredientImpl> ingredientImpl;
	private String nomRecette;
	private int portion;

	public RecetteImpl(String nomRecette)
	{
		this.nomRecette = nomRecette;
	}

	public String getNom() {
		return nomRecette;
	}

	public void setPortion(int portion)
	{
		this.portion = portion;
	}

	//TODO ajouter les ingrédients

}
