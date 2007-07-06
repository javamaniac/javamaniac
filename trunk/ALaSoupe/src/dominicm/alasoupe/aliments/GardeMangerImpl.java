package dominicm.alasoupe.aliments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GardeMangerImpl implements GardeManger {

	private Map<String, Aliment> aliments;

	public GardeMangerImpl()
	{
		aliments = new HashMap<String, Aliment>();
	}

	public String toString()
	{
		//TODO overrider les toString
		return null;
	}
	
	public Aliment getAliment(String aliment)
	{
		return aliments.get(aliment);
	}

	public void createAliment(String aliment)
	{
		//FIXME création de l'aliment
		aliments.put(aliment, null);
		
	}

	public List<Aliment> getListAliments()
	{
		// TODO créer getListAliments()
		return null;
	}

}
