package dominicm.alasoupe;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dominicm.alasoupe.aliments.GardeManger;
import dominicm.alasoupe.aliments.GardeMangerImpl;
import dominicm.alasoupe.menu.Menu;
import dominicm.alasoupe.menu.MenuImpl;
import dominicm.alasoupe.menu.Mets;
import dominicm.alasoupe.menu.Repas;
import dominicm.alasoupe.recettes.CatalogueDeRecettes;
import dominicm.alasoupe.recettes.CatalogueDeRecettesImpl;
import dominicm.alasoupe.recettes.RecetteNotFoundException;
import dominicm.util.DateUtil;

/**
 * Service principal.
 * @author Dominic
 *
 */
public class ALaSoupe {

	// singleton
	private static ALaSoupe instance;
	
	private CatalogueDeRecettes catalogueDeRecettes;
	private GardeManger gardeManger;
	private Map<Date, Menu> menus = new HashMap<Date, Menu>();

	private ALaSoupe() throws ParseException, RecetteNotFoundException
	{
		catalogueDeRecettes = new CatalogueDeRecettesImpl();
		gardeManger = new GardeMangerImpl();
		
		// création de recettes
		initialisationDesRecettes();
		initialisationMenu();
		
	}

	// singleton
	public static ALaSoupe getInstance() throws ParseException, RecetteNotFoundException
	{
		if (instance == null)
		{
			instance = new ALaSoupe();
		}
		return instance;
	}
	
	public String toString()
	{
		//TODO overrider les toString
		return null;
	}
		
	private void initialisationMenu() throws ParseException, RecetteNotFoundException
	{

		// création menu1
		{
			Date date = DateUtil.stringToDate("2007-07-01");

			Menu menu = ALaSoupe.createMenu(date);
			menu.setNom("Menu vacances!");
			
			
			// repas #1
			{
				Repas repas = menu.createRepas(date, Menu.SOUPER);
					
				// création du repas
				Mets soupe = catalogueDeRecettes.createMets("soupe", 3);
				Mets steak = catalogueDeRecettes.createMets("steak", 3);
				repas.addMets(soupe);
				repas.addMets(steak);
			}
			
			// repas #2
			{
				Repas repas = menu.createRepas(DateUtil.stringToDate("2007-07-02"), Menu.DINER);
					
				// création du repas
				Mets club = catalogueDeRecettes.createMets("club sandwich", 3);
				repas.addMets(club);
			}
			
			// repas #3
			{
				Repas repas = menu.createRepas(DateUtil.stringToDate("2007-07-02"), Menu.SOUPER);
					
				// création du repas
				Mets escalope = catalogueDeRecettes.createMets("escalope de veau", 3);
				Mets fenouil = catalogueDeRecettes.createMets("fenouil", 3);
				repas.addMets(escalope);
				repas.addMets(fenouil);
			}
			
			menus.put(date, menu);
		}

		// création menu2
		{
			Date date = DateUtil.stringToDate("2007-08-01");

			Menu menu = ALaSoupe.createMenu(date);
			menu.setNom("Menu août");
			
			
			// repas #1
			{
				Repas repas = menu.createRepas(date, Menu.SOUPER);
					
				// création du repas
				Mets pizza = catalogueDeRecettes.createMets("Pizza", 3);
				Mets cesar = catalogueDeRecettes.createMets("Salade césar", 3);
				repas.addMets(pizza);
				repas.addMets(cesar);
			}
			
			menus.put(date, menu);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Menu> getListMenu()
	{
		return new ArrayList(menus.values());
	}

	public Repas getRepas(Date date)
	{
		return null;
	}
	
	public Menu getMenu(Date date)
	{
		return menus.get(date);
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
	private static Menu createMenu(String _date) throws ParseException
	{
		Date date = DateUtil.stringToDate(_date);
		
		return createMenu(date);
	}

	private static Menu createMenu(Date date) 
	{
		return  new MenuImpl(date);
	}

	public GardeManger getGardeManger()
	{
		return gardeManger;
	}



}
