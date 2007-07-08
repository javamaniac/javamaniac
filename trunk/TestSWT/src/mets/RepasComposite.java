package mets;

import java.text.ParseException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import dominicm.alasoupe.ALaSoupe;
import dominicm.alasoupe.menu.Menu;
import dominicm.alasoupe.menu.Mets;
import dominicm.alasoupe.menu.Repas;
import dominicm.alasoupe.menu.RepasImpl;
import dominicm.alasoupe.recettes.RecetteNotFoundException;

public class RepasComposite extends Composite {

	private Group group1;
	private Composite par;

	public RepasComposite(Composite parent, int style) {
		super(parent, style);

		par = parent;
		setLayout(new GridLayout());
		//setLayout(new FillLayout());
		//setLayout(new RowLayout());
		this.setSize(100,400);

		group1 = new Group(this, SWT.SHADOW_IN|SWT.TOP);
		group1.setSize(100, 400);
		//group1.setText("Repas");
	    group1.setLayout(new RowLayout(SWT.VERTICAL));

	    ALaSoupe aLaSoupe;
		try {
			aLaSoupe = ALaSoupe.getInstance();
//			Menu menu = aLaSoupe.getMenu();	  
//			Repas repas = menu.getRepas(ALaSoupe.stringToDate("2007-07-01"));
//			List<Mets> listeMets =  repas.getListMets();
//			for (Mets mets : listeMets) {
//				new MetsComposite(group1, mets);
//			}
		} catch (Exception e) {
			// TODO 5 géré l'erreur
			e.printStackTrace();
		}
	    //Repas repas = new RepasImpl();
	    
	    
		//new MetsComposite(group1, "Club sandwich");
		//new MetsComposite(group1, "Soupe");
		//new MetsComposite(group1, "Salade");
	    Button b = new Button(group1, SWT.PUSH);
	    b.setText("+");
		b.setEnabled(true);

        b.addSelectionListener(
        		new SelectionListener() 
        		{
		            public void widgetSelected(SelectionEvent event) {
		              //text.setText("No problem");
		            	System.out.println("hit ");
		        	    System.out.println(group1.getChildren().length);
		            	addItem("patate frite");
		        	    System.out.println(group1.getChildren().length);

		            }
		
					public void widgetDefaultSelected(SelectionEvent event) {
		              //text.setText("No worries!");
		            }
		         }
        		);

		
		pack();

		//initialize();
	}

    private void addItem(String string) {
    	new MetsComposite(group1, string);
		this.redraw();
		this.pack();
		par.redraw();
		par.pack();
	}


	private void initialize() {
		//setSize(new Point(300, 200));
		
		
	}


}
