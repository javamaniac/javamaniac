package dominicm.alasoupe.recettes;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import dominicm.alasoupe.aliments.Aliment;
import dominicm.alasoupe.recettes.ingredients.Ingredient;
import dominicm.alasoupe.recettes.ingredients.IngredientImpl;
import dominicm.alasoupe.recettes.ingredients.Quantite;
import dominicm.alasoupe.recettes.ingredients.UniteMesure;

public class RecetteImpl implements Recette {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RecetteImpl.class);

	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	private List<Classifiable> classifiable;
	private String nomRecette;
	private int portion;

	// TODO créer une classe Instruction
	private String instructions = "";

	public RecetteImpl(String nomRecette)
	{
		this.nomRecette = nomRecette;
		//ingedients.add(new IngredientImpl());
	}

	public String getNom() {
		return nomRecette;
	}
	
	public void addIngredient(Quantite quantite, UniteMesure uniteMesure, Aliment aliment)
	{
		ingredients.add(new IngredientImpl(quantite, uniteMesure, aliment));
		logger.info("ajout de l'ingrédient : " + quantite + " " + uniteMesure + " " + aliment);
	}

	public void setPortion(int portion)
	{
		this.portion = portion;
	}

	public List<Ingredient> getListIngredients()
	{
		return ingredients;
	}

	public String getInstructions()
	{
		return instructions;
	}
	
	public void appendInstructions(String instructions)
	{
		//TODO enlever les retours finaux
		this.instructions += instructions + "\n\n";
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Recette : " + getNom()).append("\n");
		List<Ingredient> ingredients = getListIngredients();
		for (Ingredient ingredient : ingredients)
		{
			sb.append("\t").append(ingredient.toString()).append("\n");
		}
		sb.append("\n").append(instructions);

		return sb.toString();
	}

	//TODO ajouter les ingrédients

}
