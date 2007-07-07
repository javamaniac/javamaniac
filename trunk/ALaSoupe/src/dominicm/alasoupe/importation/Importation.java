package dominicm.alasoupe.importation;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import dominicm.alasoupe.ALaSoupe;
import dominicm.alasoupe.aliments.Aliment;
import dominicm.alasoupe.aliments.GardeManger;
import dominicm.alasoupe.recettes.CatalogueDeRecettes;
import dominicm.alasoupe.recettes.Recette;
import dominicm.alasoupe.recettes.RecetteImpl;
import dominicm.alasoupe.recettes.RecetteNotFoundException;
import dominicm.alasoupe.recettes.ingredients.Quantite;
import dominicm.alasoupe.recettes.ingredients.UniteMesure;
import dominicm.alasoupe.recettes.ingredients.UniteMesureImpl;
import dominicm.util.FileUtils;

public class Importation
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Importation.class);

	private ALaSoupe laSoupe;
	private CatalogueDeRecettes catalogueDeRecettes;


	private Recette recetteCourante = null;

	public Importation() throws ParseException, RecetteNotFoundException
	{
		laSoupe = ALaSoupe.getInstance();
		catalogueDeRecettes = laSoupe.getCatalogueDeRecettes();
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
				//logger.debug("On laisse tomber... '" + ligne + "'");
				// il s'agit d'une ligne non valide
				// on ne fait rien
			}
		}
		
		System.out.println(catalogueDeRecettes);
		
		/*
		System.out.println("----------------");
		GardeManger gardeManger = ALaSoupe.getInstance().getGardeManger();
		List<Aliment> aliments = gardeManger.getListAliments();
		for (Aliment aliment : aliments) 
		{
			System.out.println("----------------------------------------");
			System.out.println("\nAliment : " + aliment.getNom());
			System.out.println(aliment.toString());
		}*/
		
	}

	private void traiter(String prefixe, String suffixe) throws ParseException, RecetteNotFoundException
	{
		
		if (prefixe.equalsIgnoreCase("recette"))
		{
			// TODO utiliser une factory method 
			recetteCourante = catalogueDeRecettes.createRecette(suffixe);
			logger.info("Création de la recette " + suffixe + " est en cours...");
		}

		if (recetteCourante != null)
		{
			if (prefixe.equalsIgnoreCase("portion"))
			{
				recetteCourante.setPortion((new Integer(suffixe)).intValue());
			}
			else if (prefixe.equalsIgnoreCase("texte"))
			{
				recetteCourante.appendInstructions(suffixe);
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
					Quantite quantite = traitementQuantite(temp[0]);
					UniteMesure uniteMesure = traitementUnite(temp[1]);
					Aliment aliment = traitementAliment(temp[2]);
					
					// FIXME 111 utilié un vrai RecetteImpl
					recetteCourante.addIngredient(quantite, uniteMesure, aliment);
				}
					
			}
		}
	}

	private Quantite traitementQuantite(String temp)
	{
		return new Quantite(temp);
	}

	private UniteMesure traitementUnite(String temp)
	{
		// TODO utiliser une factory pour créer les unites
		return new UniteMesureImpl(temp);
	}

	private Aliment traitementAliment(String alimentNom) throws ParseException, RecetteNotFoundException
	{
		GardeManger gardeManger = ALaSoupe.getInstance().getGardeManger();
		Aliment aliment = gardeManger.getAliment(alimentNom);
		if (aliment == null)
		{
			gardeManger.createAliment(alimentNom);
			aliment = gardeManger.getAliment(alimentNom);
		}

		return aliment;
	}

	public static void main(String args[]) throws Exception
	{
		Importation i = new Importation();
		File file = new File("D:/workspace/ALaSoupe0.1/src/importation.txt");
		i.importFromFile(file);
	}
}
