package dominicm.alasoupe.menu;

import dominicm.alasoupe.recettes.Recette;

public interface Mets {

	public void setRecette(Recette recette);
	public Recette getRecette();

	public void setNom(String nom);
	public String getNom();

}
