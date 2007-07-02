package dominicm.alasoupe;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import dominicm.alasoupe.menu.Menu;
import dominicm.alasoupe.menu.MenuImpl;
import dominicm.alasoupe.menu.Mets;
import dominicm.alasoupe.menu.Repas;
import dominicm.alasoupe.recettes.CatalogueDeRecettes;
import dominicm.alasoupe.recettes.CatalogueDeRecettesImpl;
import dominicm.alasoupe.recettes.Recette;
import dominicm.alasoupe.recettes.RecetteNotFoundException;

public class ALaSoupe {

	private CatalogueDeRecettes catalogueDeRecettes;

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws RecetteNotFoundException 
	 */
	public static void main(String[] args) throws ParseException, RecetteNotFoundException {
		
		ALaSoupe aLaSoupe = new ALaSoupe();
		aLaSoupe.run();
	}

	private void run() throws ParseException, RecetteNotFoundException {
		catalogueDeRecettes = new CatalogueDeRecettesImpl();
		
		// création de recettes
		initialisationDesRecettes();

		
		System.out.println("À la soupe!\n");
		Menu menu = ALaSoupe.createMenu("2007-07-01");
		menu.setNom("Menu vacances!");
		
		
		// repas #1
		{
			Repas repas = menu.createRepas(stringToDate("2007-07-01"), Menu.SOUPER);
				
			// création du repas
			Mets soupe = catalogueDeRecettes.createMets("soupe", 3);
			Mets steak = catalogueDeRecettes.createMets("steak", 3);
			repas.addMets(soupe);
			repas.addMets(steak);
		}
		
		// repas #2
		{
			Repas repas = menu.createRepas(stringToDate("2007-07-02"), Menu.DINER);
				
			// création du repas
			Mets club = catalogueDeRecettes.createMets("club sandwich", 3);
			repas.addMets(club);
		}
		
		// repas #3
		{
			Repas repas = menu.createRepas(stringToDate("2007-07-02"), Menu.SOUPER);
				
			// création du repas
			Mets escalope = catalogueDeRecettes.createMets("escalope de veau", 3);
			Mets fenouil = catalogueDeRecettes.createMets("fenouil", 3);
			repas.addMets(escalope);
			repas.addMets(fenouil);
		}
		
		System.out.println("----------------------------------------");
		System.out.println("\n\nMenu (" + menu.getNom() + ") du " + menu.getDate());
		System.out.println(menu.toString());
		
		System.out.println("\n\nau revoir...");
	}

	private void initialisationDesRecettes() {
		
		// création de recettes
		catalogueDeRecettes.createRecette("soupe");
		catalogueDeRecettes.createRecette("steak");
		catalogueDeRecettes.createRecette("club sandwich");
		catalogueDeRecettes.createRecette("escalope de veau");
		catalogueDeRecettes.createRecette("fenouil");
	}

	/**
	 * Création d'un menu à partir d'une date
	 * @param _date String de format (aaaa-mm-jj)
	 * @return
	 * @throws ParseException
	 */
	private static Menu createMenu(String _date) throws ParseException {

		Date date = stringToDate(_date);
		
		return new MenuImpl(date);
	}

	/**
	 * Convertir une date String en Date
	 * @param _date
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String _date) throws ParseException {
		// convertir la date String en Date
		DateFormat df = DateFormat.getDateInstance();
		Date date = df.parse(_date);
		return date;
	}

}
