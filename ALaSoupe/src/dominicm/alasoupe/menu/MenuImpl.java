package dominicm.alasoupe.menu;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class MenuImpl implements Menu {

	private List<Repas> listeRepas = new ArrayList<Repas>();
	Date date; // date du d�but du menu
	private String nom;

//	public MenuImpl(List<Repas> repas) {
//		listeRepas = repas;
//	}

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
		System.out.println("repas du " + DateFormat.getInstance().format(date) + " a �t� fait");
		Repas repas = new RepasImpl(date, moment); 
		listeRepas.add(repas);
		return repas;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDate() {
		return DateFormat.getDateInstance().format(date);
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (Repas repas : listeRepas) {
			
			//TODO prendre en compte les 3 repas
			String moment = ((repas.getMoment() == 2) ? "diner" : "souper");
			// souper 2 juillet 2007 - Steak et frite 
			sb.append("\n").append(String.format("%s %s - %s", moment, repas.getDate(), repas.getAllMets()));
			//sb.append(repas.getDate).append(" - ").append("\n")
		}
		return sb.toString();
	}

}
