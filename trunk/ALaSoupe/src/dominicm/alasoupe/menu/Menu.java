package dominicm.alasoupe.menu;

import java.util.Date;
import java.util.List;

public interface Menu {

	public int DEJEUNER = 1;
	public int DINER = 2;
	public int SOUPER = 3;

	void setDate(Date date);

	String toString();

	List<Repas> listRepas();

	void setNom(String nom);

	Repas createRepas(Date date, int i);

	String getDate();
	
	public String getNom();
	
}
