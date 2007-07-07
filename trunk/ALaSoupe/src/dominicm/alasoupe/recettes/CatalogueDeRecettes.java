package dominicm.alasoupe.recettes;

import java.util.List;

import dominicm.alasoupe.menu.Mets;

public interface CatalogueDeRecettes {

	Mets createMets(String string, int i) throws RecetteNotFoundException;
	
	public Recette createRecette(String nomRecette);
	
	public List<Recette> getListRecettes();
}
