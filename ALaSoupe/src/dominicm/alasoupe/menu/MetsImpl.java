package dominicm.alasoupe.menu;

import dominicm.alasoupe.recettes.Recette;

public class MetsImpl implements Mets {

	private Recette recette;
	private String nomMets;

//	public MetsImpl(Recette recette) {
//		setRecette(recette);
//	}

	public MetsImpl(Recette recette, int nbPortion) {
		setRecette(recette);
		//TODO nbPortion
	}
	
	public void setRecette(Recette recette) {
		this.recette = recette;
		setNom(recette.getNom());
	}

	public void setNom(String nom) {
		nomMets = nom;
	}

	public String getNom() {
		return nomMets;
	}

	public Recette getRecette() {
		return recette;
	}

}
