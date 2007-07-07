package dominicm.alasoupe.recettes.ingredients;

public class UniteMesureImpl extends UniteMesure
{
	private String uniteMesure;
	
	public UniteMesureImpl()
	{
	}
	
	public UniteMesureImpl(String uniteMesure)
	{
		setUniteMesure(uniteMesure);
	}
	

	public String getUniteMesure()
	{
		return uniteMesure;
	}

	public void setUniteMesure(String uniteMesure)
	{
		this.uniteMesure = uniteMesure;
	}
	
	public String toString()
	{
		return getUniteMesure();
	}
}
