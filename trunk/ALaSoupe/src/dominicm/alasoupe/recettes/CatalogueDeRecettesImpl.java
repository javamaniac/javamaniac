package dominicm.alasoupe.recettes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dominicm.alasoupe.menu.Mets;
import dominicm.alasoupe.menu.MetsImpl;
import dominicm.alasoupe.recettes.ingredients.Ingredient;

public class CatalogueDeRecettesImpl implements CatalogueDeRecettes {

	private Map<String, Recette> recettes;

	public CatalogueDeRecettesImpl() {
		recettes = new HashMap<String, Recette>();
	}

	public Mets createMets(String nomRecette, int nbPortion) throws RecetteNotFoundException {
		if (!recettes.containsKey(nomRecette))
		{
			// recette non trouvé, on la crée
			System.err.println("Aucune recette trouvée au nom de '" + nomRecette + "'");
			createRecette(nomRecette);
			//throw new RecetteNotFoundException("Aucune recette trouvée au nom de '" + nomRecette + "'");
		}
		
		return new MetsImpl(recettes.get(nomRecette), nbPortion);
	}

	public Recette createRecette(String nomRecette) {
		RecetteImpl recette = new RecetteImpl(nomRecette);
		recettes.put(nomRecette, recette);
		return recette;
		
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		List<Recette> listRecettes = getListRecettes();
		for (Recette recette : listRecettes)
		{
			sb.append(recette.toString());
		}
		return sb.toString();
	}

	public List<Recette> getListRecettes()
	{
		return new ArrayList<Recette>(recettes.values());
	}
}
