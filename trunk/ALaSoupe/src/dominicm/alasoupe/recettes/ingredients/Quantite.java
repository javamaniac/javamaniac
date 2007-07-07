package dominicm.alasoupe.recettes.ingredients;

public class Quantite
{
	private float quantite;

	public Quantite(String quantite)
	{
		setQuantite(quantite);
	}

	public String getQuantite()
	{
		return new Float(quantite).toString();
	}

	public void setQuantite(String quantite)
	{
		this.quantite = (new Float(quantite)).floatValue();
	}
	
	public String toString()
	{
		return getQuantite();
	}
	
	
	
}
