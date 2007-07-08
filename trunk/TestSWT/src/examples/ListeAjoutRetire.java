package examples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class ListeAjoutRetire
{

	Display d;

	Shell s;

	private Table t;

	ListeAjoutRetire()
	{
		d = new Display();
		s = new Shell(d);

		s.setSize(250, 200);
		s.setImage(new Image(d, "C:/wtools/Aptana/aptana.ico"));
		s.setText("A Table Shell Example");
		s.setLayout(new FillLayout());

		t = new Table(s, SWT.CHECK | SWT.BORDER);
		TableColumn tc1 = new TableColumn(t, SWT.CENTER);
		// TableColumn tc2 = new TableColumn(t, SWT.CENTER);
		// TableColumn tc3 = new TableColumn(t, SWT.CENTER);
		tc1.setText("First Name");
		// tc2.setText("Last Name");
		// tc3.setText("Address");
		tc1.setWidth(70);
		// tc2.setWidth(70);
		// tc3.setWidth(80);
		t.setHeaderVisible(true);

		TableItem item1 = new TableItem(t, SWT.NONE);
		item1.setText(new String[]
		{ "Tim", "Hatton", "Kentucky" });
		TableItem item2 = new TableItem(t, SWT.NONE);
		item2.setText(new String[]
		{ "Caitlyn", "Warner", "Ohio" });
		TableItem item3 = new TableItem(t, SWT.NONE);
		item3.setText(new String[]
		{ "Reese", "Miller", "Ohio" });

		Button b_add = new Button(s, SWT.PUSH);
		b_add.setText("add");
		b_add.pack();
		b_add.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				// text.setText("No problem");
				addItem(new String[]
				{ "Reese", "Miller", "Ohio" });
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{
				// text.setText("No worries!");
			}
		});

		Button b_remove = new Button(s, SWT.PUSH);
		b_remove.setText("remove");
		b_remove.pack();
		b_remove.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				// text.setText("No problem");
				// int selected = t.getSelectedIndex( );
				System.out.println("remove...");
				System.out.println("getSelectionCount = "
						+ t.getSelectionCount());
				System.out.println("getItemCount = " + t.getItemCount());
				TableItem[] items = t.getItems();
				for (TableItem item : items)
				{
					System.out.println(item.getText() + " - "
							+ item.getChecked());
					if (item.getChecked())
					{
						item.dispose();
					}
				}
				// t.select(index)
				// for (int i = 0; i < array.length; i++) {
				// array_type array_element = array[i];
				//							
				// }
				// removeItem(new String[] {"Reese","Miller","Ohio"});
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{
				// text.setText("No worries!");
			}
		});

		s.open();
		while (!s.isDisposed())
		{
			if (!d.readAndDispatch())
				d.sleep();
		}
		d.dispose();
	}

	public void addItem(String[] string)
	{
		TableItem item4 = new TableItem(t, SWT.NONE);
		item4.setText(string);
	}

	public static void main(String[] args)
	{
		// SimpleShell ss = new SimpleShell( );
		ListeAjoutRetire t = new ListeAjoutRetire();
	}
}
