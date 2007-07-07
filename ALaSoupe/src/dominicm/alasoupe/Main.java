package dominicm.alasoupe;

import java.text.ParseException;
import java.util.List;

import dominicm.alasoupe.menu.Menu;
import dominicm.alasoupe.recettes.RecetteNotFoundException;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws RecetteNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println("À la soupe!\n");

		ALaSoupe aLaSoupe = ALaSoupe.getInstance();
		//Menu menu = aLaSoupe.getMenu();
		List<Menu> menus = aLaSoupe.getListMenu();
		for (Menu menu : menus) 
		{
			System.out.println("----------------------------------------");
			System.out.println("\n\nMenu (" + menu.getNom() + ") du " + menu.getDate());
			System.out.println(menu.toString());
		}
		
		System.out.println("\n\nau revoir...");
	}

}
