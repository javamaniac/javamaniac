package dominicm.alasoupe.gui.zones;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


import dominicm.alasoupe.gui.composites.RepasComposite;
import dominicm.alasoupe.gui.pojos.Messager;


/**
 * Partie visuel de la fenetre où on voit le menu.
 * @author Dominic
 *
 */
public class ZoneMenuDeLaSemaine
{

	public ZoneMenuDeLaSemaine(Messager messager)
	{
		// setSize(new Point(300, 200));
		Shell shell = messager.getShell();
		
		Composite menuComposite = new Composite(shell, 0);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalAlignment = GridData.FILL;
		menuComposite.setLayoutData(gridData);

		//menuComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
		//GridLayout gridLayout = new GridLayout();
		//gridLayout.numColumns = 7;
		menuComposite.setLayout(new FillLayout());

		

		// test2
		// {
		// Table t = new Table(this, SWT.BORDER);
		//
		// TableColumn tc1 = new TableColumn(t, SWT.CENTER);
		// TableColumn tc2 = new TableColumn(t, SWT.CENTER);
		// TableColumn tc3 = new TableColumn(t, SWT.CENTER);
		// tc1.setText("First Name");
		// tc2.setText("Last Name");
		// tc3.setText("Address");
		// tc1.setWidth(70);
		// tc2.setWidth(70);
		// tc3.setWidth(80);
		// t.setHeaderVisible(true);
		//
		// TableItem item1 = new TableItem(t,SWT.NONE);
		// item1.set(new RepasComposite(this, 0)); //setText(new String[]
		// {"Tim","Hatton","Kentucky"});
		// TableItem item2 = new TableItem(t,SWT.NONE);
		// item2.setText(new String[] {"Caitlyn","Warner","Ohio"});
		// TableItem item3 = new TableItem(t,SWT.NONE);
		// item3.setText(new String[] {"Reese","Miller","Ohio"});
		//			
		// }

		// test
		// {
		// // Set up the table layout
		// TableLayout layout = new TableLayout();
		// layout.addColumnData( new ColumnWeightData(1));
		// layout.addColumnData(new ColumnWeightData(33, 75, true));
		// layout.addColumnData(new ColumnWeightData(33, 75, true));
		// Table table = new Table(this, SWT.SINGLE);
		// table.setLayout(layout);
		// // Add columns to the table
		// TableColumn column1 = new TableColumn(table, SWT.CENTER);
		// TableColumn column2 = new TableColumn(table, SWT.CENTER);
		// TableColumn column3 = new TableColumn(table, SWT.CENTER);
		// TableItem item = new TableItem(table, SWT.NONE);
		// item.setText( new String[] { "column 1",
		// "column 2",
		// "column 3" } );
		// item = new TableItem(table, SWT.NONE);
		// item.setText( new String[] { "a", "b", "c" } );
		// }


/*
		new LabelMenuComposite(menuComposite, "Lundi");
		new LabelMenuComposite(menuComposite, "Mardi");
		new LabelMenuComposite(menuComposite, "Mercredi");
		new LabelMenuComposite(menuComposite, "Jeudi");
		new LabelMenuComposite(menuComposite, "Vendredi");
		new LabelMenuComposite(menuComposite, "Samedi");
		new LabelMenuComposite(menuComposite, "Dimanche");
*/
		SashForm sf = new SashForm(menuComposite, SWT.VERTICAL);
		//sf.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
		

		Composite sf1 = new Composite(sf, SWT.NONE);
		sf1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
		//sf1.setLayout(new FillLayout());
		GridData gridDataSf1 = new GridData();
		gridDataSf1.grabExcessHorizontalSpace = true;
		gridDataSf1.grabExcessVerticalSpace = true;
		gridDataSf1.verticalAlignment = GridData.FILL;
		gridDataSf1.horizontalAlignment = GridData.FILL;
		sf1.setLayoutData(gridDataSf1);
		sf1.setLayout(new FillLayout());
		
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		new RepasComposite(sf1, messager);
		sf1.pack();

		Composite sf2 = new Composite(sf, SWT.NONE);
		sf2.setLayout(new FillLayout());
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		new RepasComposite(sf2, messager);
		sf2.pack();

		Composite sf3 = new Composite(sf, SWT.NONE);
		sf3.setLayout(new FillLayout());
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		new RepasComposite(sf3, messager);
		sf3.pack();
		
		sf.pack();

		menuComposite.pack();
	}

}
