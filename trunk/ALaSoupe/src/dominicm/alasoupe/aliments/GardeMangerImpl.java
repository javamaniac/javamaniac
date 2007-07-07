package dominicm.alasoupe.aliments;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GardeMangerImpl implements GardeManger {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GardeMangerImpl.class);

	private Map<String, Aliment> aliments;

	public GardeMangerImpl()
	{
		aliments = new HashMap<String, Aliment>();
	}

	public String toString()
	{
		//TODO overrider les toString
		return "Contenu de tous le garde mangé!!!!!!!!!!";
	}
	
	public Aliment getAliment(String aliment)
	{
		return aliments.get(aliment);
	}

	public void createAliment(String aliment)
	{
		logger.info("Création de l'aliment : " + aliment);

		//FIXME création de l'aliment
		aliments.put(aliment, new AlimentImpl(aliment));
		
	}

	public List<Aliment> getListAliments()
	{
		return new ArrayList(aliments.values());
	}

}
