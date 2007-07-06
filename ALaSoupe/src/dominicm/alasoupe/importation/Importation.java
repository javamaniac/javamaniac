package dominicm.alasoupe.importation;

import org.apache.log4j.Logger;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import dominicm.alasoupe.ALaSoupe;
import dominicm.alasoupe.aliments.GardeManger;
import dominicm.alasoupe.menu.Menu;
import dominicm.alasoupe.recettes.Recette;
import dominicm.alasoupe.recettes.RecetteImpl;
import dominicm.alasoupe.recettes.RecetteNotFoundException;
import dominicm.util.FileUtils;

public class Importation
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Importation.class);

	private ALaSoupe laSoupe;

	public Importation() throws ParseException, RecetteNotFoundException
	{
		laSoupe = ALaSoupe.getInstance();
	}

	public void importFromFile(File file) throws Exception
	{
		List<String> lignes = FileUtils.extractLines(file);
		for (String ligne : lignes)
		{
			ligne = ligne.trim();

			if (ligne.contains("="))
			{
				logger.info("Importation en cours de la ligne '" + ligne + "'");

				// ligne à traiter
				String[] temp = ligne.split("=");
				String prefixe = temp[0];
				String suffixe = temp[1];

				try
				{
					traiter(prefixe.trim(), suffixe.trim());
				}
				catch (ParseException e)
				{
					logger.warn("erreur de traitement de la ligne : '" + ligne + "', " + e.getMessage());
				}
				catch (RecetteNotFoundException e)
				{
					logger.warn("erreur de traitement de la ligne : '" + ligne + "', " + e.getMessage());
				}
			}
			else
			{
				logger.debug("On laisse tomber... '" + ligne + "'");
				// il s'agit d'une ligne non valide
				// on ne fait rien
			}

		}
		
		System.out.println("----------------");
		GardeManger gardeManger = ALaSoupe.getInstance().getGardeManger();
		List<Aliment> aliments = gardeManger.getListAliments();
		for (Menu aliment : aliments) 
		{
			System.out.println("----------------------------------------");
			System.out.println("\n\nMenu (" + menu.getNom() + ") du " + menu.getDate());
			System.out.println(menu.toString());
		}
		
	}

	private void traiter(String prefixe, String suffixe) throws ParseException, RecetteNotFoundException
	{
		Recette recette = null;
		StringBuilder sb = new StringBuilder();

		if (prefixe.equalsIgnoreCase("recette"))
		{
			recette = new RecetteImpl(suffixe);
			logger.info("Création de la recette " + suffixe + " est en cours...");
		}

		if (recette != null)
		{
			if (prefixe.equalsIgnoreCase("portion"))
			{
				recette.setPortion((new Integer(suffixe)).intValue());
			}
			else if (prefixe.equalsIgnoreCase("texte"))
			{
				// TODO enlever les derniers retours
				sb.append(suffixe).append("\n\n");
			}
			else if (prefixe.equalsIgnoreCase("ingredient")
					|| prefixe.equalsIgnoreCase("ingrédient"))
			{
				String[] temp = suffixe.split("[|]");
				if (temp.length < 3)
				{
					logger.warn("ingrédient non valide :  " + suffixe );
				}
				else
				{
					traitementQuantite(temp[0]);
					traitementUnite(temp[1]);
					traitementAliment(temp[2]);
				}
					
			}
		}
	}

	private void traitementQuantite(String temp)
	{
		int quantite = (new Integer(temp)).intValue();
	}

	private void traitementUnite(String temp)
	{
		// TODO création des quantités
		String unite = temp;
	}

	private void traitementAliment(String temp) throws ParseException, RecetteNotFoundException
	{
		String aliment = temp;
		
		GardeManger gardeManger = ALaSoupe.getInstance().getGardeManger();
		if (gardeManger.getAliment(aliment) == null)
		{
			gardeManger.createAliment(aliment);
			logger.info("Création de l'aliment : " + aliment);
		}
	}

	public static void main(String args[]) throws Exception
	{
		Importation i = new Importation();
		File file = new File("D:/workspace/ALaSoupe0.1/src/importation.txt");
		i.importFromFile(file );
	}
}
