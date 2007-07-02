package dominicm.alasoupe.recettes;

import dominicm.alasoupe.menu.Mets;

public interface CatalogueDeRecettes {

	Mets createMets(String string, int i) throws RecetteNotFoundException;
	
	public void createRecette(String nomRecette);

}
