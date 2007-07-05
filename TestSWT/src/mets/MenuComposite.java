package mets;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class MenuComposite extends Composite {

	public MenuComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		//setSize(new Point(300, 200));

		this.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		
		setLayout(gridLayout);
		//setLayout(new FillLayout());
		//setLayout(new RowLayout());

		
		//test2
//		{
//			Table t = new Table(this, SWT.BORDER);
//
//	        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
//	        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
//	        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
//	        tc1.setText("First Name");
//	        tc2.setText("Last Name");
//	        tc3.setText("Address");
//	        tc1.setWidth(70);
//	        tc2.setWidth(70);
//	        tc3.setWidth(80);
//	        t.setHeaderVisible(true);
//
//	        TableItem item1 = new TableItem(t,SWT.NONE);
//	        item1.set(new RepasComposite(this, 0)); //setText(new String[] {"Tim","Hatton","Kentucky"});
//	        TableItem item2 = new TableItem(t,SWT.NONE);
//	        item2.setText(new String[] {"Caitlyn","Warner","Ohio"});
//	        TableItem item3 = new TableItem(t,SWT.NONE);
//	        item3.setText(new String[] {"Reese","Miller","Ohio"});
//			
//		}
		
		//test
//		{
////			Set up the table layout
//			TableLayout layout = new TableLayout();
//			layout.addColumnData( new ColumnWeightData(1));
//			layout.addColumnData(new ColumnWeightData(33, 75, true));
//			layout.addColumnData(new ColumnWeightData(33, 75, true));
//			Table table = new Table(this, SWT.SINGLE);
//			table.setLayout(layout);
////			Add columns to the table
//			TableColumn column1 = new TableColumn(table, SWT.CENTER);
//			TableColumn column2 = new TableColumn(table, SWT.CENTER);
//			TableColumn column3 = new TableColumn(table, SWT.CENTER);
//			TableItem item = new TableItem(table, SWT.NONE);
//			item.setText( new String[] { "column 1",
//			"column 2",
//			"column 3" } );
//			item = new TableItem(table, SWT.NONE);
//			item.setText( new String[] { "a", "b", "c" } );			
//		}
		
		
	    
		
		new LabelMenuComposite(this, "Lundi");
		new LabelMenuComposite(this, "Mardi");
		new LabelMenuComposite(this, "Mercredi");
		new LabelMenuComposite(this, "Jeudi");
		new LabelMenuComposite(this, "Vendredi");
		new LabelMenuComposite(this, "Samedi");
		new LabelMenuComposite(this, "Dimanche");
		
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);

		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);

		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);
		new RepasComposite(this, 0);

		pack();
	}


}
