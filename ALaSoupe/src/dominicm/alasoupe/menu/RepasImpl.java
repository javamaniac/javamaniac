package dominicm.alasoupe.menu;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominicm.alasoupe.ALaSoupe;

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
	
	public int getMoment()
	{
		return moment;
	}
	
	public String getDate()
	{
		return DateFormat.getInstance().format(date);
	}
	
	public String getAllMets()
	{
		StringBuilder sb = new StringBuilder();
		int cpt = 0;
		for (Mets mets : listeMets) {
			sb.append(mets.getNom());
			if (++cpt < listeMets.size())
			{
				sb.append(" et ");
			}
		}
		return sb.toString();
	}

}
