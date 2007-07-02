package dominicm.alasoupe.menu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class MenuImpl implements Menu {

	private List<Repas> listeRepas;
	Date date; // date du début du menu
	private String nom;

	public MenuImpl(List<Repas> repas) {
		listeRepas = repas;
	}

	public MenuImpl(Date date) {
		this.date = date;
	}

	public List<Repas> listRepas() {
		return listeRepas;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public Repas createRepas(Date date, int moment) {
		System.out.println("repas du " + DateFormat.getInstance().format(date) + " a été fait");
		return new RepasImpl(date, moment);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDate() {
		return DateFormat.getDateInstance().format(date);
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		for (Repas repas : listeRepas) {
			
			//TODO prendre en compte les 3 repas
			String moment = ((repas.getMoment() == 2) ? "diner" : "souper");
			// souper 2 juillet 2007 - Steak et frite 
			String.format("%s %s - %s", moment, repas.getDate(), repas.getAllMets());
			//sb.append(repas.getDate).append(" - ").append("\n")
		}
		return null;
	}

}
