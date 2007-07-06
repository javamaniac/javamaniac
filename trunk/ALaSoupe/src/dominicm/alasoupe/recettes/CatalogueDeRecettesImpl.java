package dominicm.alasoupe.recettes;

import java.util.HashMap;
import java.util.Map;

import dominicm.alasoupe.menu.Mets;
import dominicm.alasoupe.menu.MetsImpl;

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

	public void createRecette(String nomRecette) {
		recettes.put(nomRecette, new RecetteImpl(nomRecette));
		
	}

}
