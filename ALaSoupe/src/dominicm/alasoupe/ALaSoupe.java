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

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws RecetteNotFoundException 
	 */
	public static void main(String[] args) throws ParseException, RecetteNotFoundException {
		
		System.out.println("À la soupe!");
		Menu menu = ALaSoupe.createMenu("2007-07-01");
		menu.setNom("Menu vacances!");
		
		Repas repas = menu.createRepas(stringToDate("2007-07-01"), Menu.DINER);
			
		CatalogueDeRecettes catalogueDeRecettes = new CatalogueDeRecettesImpl();
		
		// création de recettes
		catalogueDeRecettes.createRecette("soupe");
		catalogueDeRecettes.createRecette("steak");
		
		// création du repas
		Mets soupe = catalogueDeRecettes.createMets("soupe", 3);
		Mets steak = catalogueDeRecettes.createMets("steak", 3);
		repas.addMets(soupe);
		repas.addMets(steak);

		System.out.println("\n\nMenu du " + menu.getDate());
		System.out.println(menu.toString());
		
		System.out.println("au revoir...");
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
	private static Date stringToDate(String _date) throws ParseException {
		// convertir la date String en Date
		DateFormat df = DateFormat.getDateInstance();
		Date date = df.parse(_date);
		return date;
	}

}
