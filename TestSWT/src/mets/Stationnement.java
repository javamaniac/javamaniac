package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

public class Stationnement extends Composite {

	public Stationnement(Composite parent, int style) {
		super(parent, style);

		//setLayout(new FillLayout());
		//setLayout(new RowLayout());

		this.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));

		Group group1 = new Group(parent, SWT.SHADOW_IN);
	    group1.setText("Stationnement");
	    group1.setLayout(new RowLayout(SWT.VERTICAL));
	    
		new MetsStationnement(group1);

		pack();

		//initialize();
	}
}