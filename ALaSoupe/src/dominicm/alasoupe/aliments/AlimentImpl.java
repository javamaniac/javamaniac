package dominicm.alasoupe.aliments;

public class AlimentImpl implements Aliment {

	private String nom = null;
	
	public AlimentImpl() {
	}
	
	public AlimentImpl(String aliment)
	{
		setNom(aliment);
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public String toString()
	{
		return getNom();
	}
}
