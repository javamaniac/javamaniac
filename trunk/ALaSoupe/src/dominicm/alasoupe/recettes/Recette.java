package dominicm.alasoupe.recettes;

import java.util.List;

import dominicm.alasoupe.aliments.Aliment;
import dominicm.alasoupe.recettes.ingredients.Ingredient;
import dominicm.alasoupe.recettes.ingredients.Quantite;
import dominicm.alasoupe.recettes.ingredients.UniteMesure;

public interface Recette {

	String getNom();

	void setPortion(int i);
	public void addIngredient(Quantite quantite, UniteMesure uniteMesure, Aliment aliment);

	public List<Ingredient> getListIngredients();

	void appendInstructions(String instructions);

}
