package dominicm.alasoupe.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepasImpl implements Repas {

	private List<Mets> listeMets = new ArrayList<Mets>();
	private Date date;
	private int moment;

	public RepasImpl(Date date, int moment) {
		this.date = date;
		this.moment = moment;
	}

	public void addMets(Mets mets) {
		System.out.println("ajout du mets '" + mets.getNom() + "' au repas");
		listeMets.add(mets);
	}

}
